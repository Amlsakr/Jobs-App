package com.example.jobsapp.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jobsapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}