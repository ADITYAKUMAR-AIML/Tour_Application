package com.example.tour_application

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tour_application.adapter.CategoryAdapter
import com.example.tour_application.adapter.PopularPlaces
import com.example.tour_application.databinding.ActivityMainBinding
import com.example.tour_application.databinding.ActivitySplashBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Hide system navigation & status bars AFTER the window is attached
        window.decorView.post {
            window.insetsController?.let { controller ->
                controller.hide(WindowInsets.Type.systemBars())
                controller.systemBarsBehavior =
                    WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        }
        binding.apply {
            rvItems.layoutManager = GridLayoutManager(binding.root.context, 4)
            progressBar.visibility = View.GONE
            progressBar3.visibility = View.GONE

            val names = listOf(
                "Villa", "Hotel", "Apartment", "Voucher",
                "GuestHouse", "Camp", "Explore", "Profile"
            )

            val location = listOf(
                "Paris, France",
                "New York, USA",
                "Tokyo, Japan",
                "London, UK",
                "Dubai, UAE",
                "Rome, Italy",
                "Sydney, Australia",
                "Bali, Indonesia"
            )



            val icons = listOf(
                R.drawable.guesthouse,
                R.drawable.coupon,
                R.drawable.cat1,
                R.drawable.beach1,
                R.drawable.building,
                R.drawable.beach3,
                R.drawable.villa,
                R.drawable.guesthouse
            )

            rvItems.adapter = CategoryAdapter(names, icons)


            rv.layoutManager = LinearLayoutManager(binding.root.context)
            rv.adapter = PopularPlaces(names, location , icons)
        }
    }
}
