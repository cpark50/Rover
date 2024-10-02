package com.example.rovers

import CustomAdapter
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

object BindingUtil {

    @JvmStatic
    @BindingAdapter("data")
    fun setRecyclerViewData(recyclerView: RecyclerView, data: List<Photos.MarsPhoto>?) {
        if (recyclerView.adapter is CustomAdapter) {
            (recyclerView.adapter as CustomAdapter?)?.setData(data)
        }
    }

    @JvmStatic
    @BindingAdapter("glideImageUrl")
    fun loadImage(view: ImageView, url: String?){
        if(!url.isNullOrEmpty()) {
            Glide.with(view.context)
                .load(url)
                .into(view)
        }
    }

}