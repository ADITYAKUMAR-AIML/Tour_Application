package com.example.tour_application.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tour_application.databinding.ListItemTemplateBinding

class CategoryAdapter(
    private val names: List<String>,
    private val icons: List<Int>
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemTemplateBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = names.size

    inner class ViewHolder(private val binding: ListItemTemplateBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            if (position < names.size) {
                binding.categoryText.text = names[position]
                binding.categoryIcon.setImageResource(icons[position])
            }
        }
    }
}
