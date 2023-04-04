package vb.mobilelife.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import vb.mobilelife.data.ImageModel
import vb.mobilelife.network.ApiInterface
import vb.mobilelife.paging.ImagePagingSource
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val apiService: ApiInterface) : ViewModel() {



    val listData = Pager(PagingConfig(pageSize = 1)){
        ImagePagingSource(apiService)
    }.flow.cachedIn(viewModelScope)



}