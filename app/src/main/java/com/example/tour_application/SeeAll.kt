package com.example.tour_application

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tour_application.adapter.PopularPlaces
import com.example.tour_application.databinding.ActivitySplashBinding
import com.example.tour_application.databinding.SeeallBinding

class SeeAll : AppCompatActivity() {
    private lateinit var binding: SeeallBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SeeallBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {


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


            rvPopularPlaces.layoutManager = LinearLayoutManager(binding.root.context)
            rvPopularPlaces.adapter = PopularPlaces(names, location , icons)

            back.setOnClickListener {
                finish() //To finish that activity there...
            }
        }


    }
}
