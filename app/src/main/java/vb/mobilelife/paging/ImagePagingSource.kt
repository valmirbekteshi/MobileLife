package vb.mobilelife.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import vb.mobilelife.data.ImageModel
import vb.mobilelife.network.ApiInterface

class ImagePagingSource(private val apiInterface: ApiInterface) : PagingSource<Int, ImageModel>() {
    override fun getRefreshKey(state: PagingState<Int, ImageModel>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ImageModel> {
        return try {
            val currentPage = params.key ?: 1
            val response = apiInterface.getImageList(currentPage, 10)
            val responseData = mutableListOf<ImageModel>()
            val data = response.body() ?: emptyList()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}
