package com.example.tour_application.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.tour_application.PlaceDetail
import com.example.tour_application.databinding.PopularPlaceDemoBinding

class PopularPlaces(
    private val names: List<String>,
    private val location: List<String>,
    private val icons: List<Int>,
) : RecyclerView.Adapter<PopularPlaces.ViewHolder>() {

    // Use the smaller size so we don't crash if one list is shorter
    override fun getItemCount(): Int = names.count() //Names is the list here afterall.

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PopularPlaceDemoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ViewHolder(private val binding: PopularPlaceDemoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            // ---- EDIT HERE if your binding has different view IDs ----
            // Replace `tvName` and `ivIcon` with the actual view names from PopularPlaceDemoBinding
            binding.apply {
                tvTitle.text = names[position]
                imageView.setImageResource(icons[position])
                tvLocation.text = location[position]
                RelativeL.setOnClickListener {
                    val intent = Intent(binding.root.context , PlaceDetail::class.java)
                    binding.root.context.startActivity(intent)
                }
                }
            }
        }
    }

