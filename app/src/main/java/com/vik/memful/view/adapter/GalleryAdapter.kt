package com.vik.memful.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vik.memful.R
import com.vik.memful.model.Data
import kotlinx.android.synthetic.main.gallery_item.view.*

class GalleryAdapter : RecyclerView.Adapter<GalleryAdapter.ItemViewHolder>() {

    private var data: List<Data> ? = null

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image : ImageView ? = null

        init {
            image = itemView.image
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context!!).inflate(R.layout.gallery_item, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data = data!!.get(position)
        val url = data.images?.let { it.get(0) }?.let { it.link }
        url?.let {
            Log.d(Companion.TAG, "onBindViewHolder: $url")
            Glide.with(holder.itemView.context).load(url)
                .placeholder(R.drawable.ic_placeholder).into(holder.image!!)
        }
    }

    override fun getItemCount(): Int {
        return data?.let { it.size } ?: kotlin.run { 0 }
    }

    fun setData(data: List<Data>) {
        this.data = data
        notifyDataSetChanged()
    }

    companion object {
        private const val TAG = "GalleryAdapter"
    }
}