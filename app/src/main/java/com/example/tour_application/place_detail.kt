package com.example.tour_application

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tour_application.adapter.ThumbnailAdapter
import com.example.tour_application.databinding.ActivityPlaceDetailBinding

class PlaceDetail : AppCompatActivity() {

    private lateinit var binding: ActivityPlaceDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout
        binding = ActivityPlaceDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Back button click
        binding.back.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // Dummy thumbnails (add your images in res/drawable)
        val thumbnails_id = listOf(
            R.drawable.beach1,
            R.drawable.beach3,
            R.drawable.beach2,
            R.drawable.beach4
        )

        binding.rvThumbnails.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


        binding.rvThumbnails.adapter = ThumbnailAdapter(thumbnails_id) { clickedResId ->
            binding.headerImage.setImageResource(clickedResId)
        }

    }


}


