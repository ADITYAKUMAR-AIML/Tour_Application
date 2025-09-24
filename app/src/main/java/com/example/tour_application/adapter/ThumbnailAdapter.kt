package com.example.tour_application.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tour_application.databinding.ItemThumbnailBinding

// Add a click callback so the activity can react and update the header image
class ThumbnailAdapter(
    private val thumbnails: List<Int>,
    private val onThumbClick: (Int) -> Unit
) : RecyclerView.Adapter<ThumbnailAdapter.ThumbnailViewHolder>() {

    inner class ThumbnailViewHolder(val binding: ItemThumbnailBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThumbnailViewHolder {
        val binding = ItemThumbnailBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ThumbnailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ThumbnailViewHolder, position: Int) {
        val resId = thumbnails[position]
        holder.binding.imgThumbnail.setImageResource(resId)

        // set click on the thumbnail (use root or the ImageView)
        holder.binding.root.setOnClickListener {
            onThumbClick(resId)
        }
    }

    override fun getItemCount(): Int = thumbnails.size
}
