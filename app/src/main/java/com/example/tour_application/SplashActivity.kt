package com.example.tour_application

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tour_application.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // When the user taps the GettingStarted button → open MainActivity
        binding.GettingStarted.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java)) //To get the necessary details from doin class.java ...
            finish() // close SplashActivity so user can’t go back
        }
    }
}
