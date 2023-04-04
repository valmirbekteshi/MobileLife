package vb.mobilelife.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import vb.mobilelife.data.ImageModel
import vb.mobilelife.databinding.ImageItemBinding


class ImageAdapter : PagingDataAdapter<ImageModel,ImageAdapter.ImageViewHolder>(ImageDiffCallBack()) {

    inner class ImageViewHolder(val binding: ImageItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ImageItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val model = getItem(position)
        holder.binding.apply {
            imageTitle.text = model?.author

            Glide.with(imageView.context)
                .load(model?.download_url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
        }

    }
}

class ImageDiffCallBack : DiffUtil.ItemCallback<ImageModel>() {

    override fun areItemsTheSame(oldItem: ImageModel, newItem: ImageModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ImageModel, newItem: ImageModel): Boolean {
        return oldItem == newItem
    }
}