package com.example.jobsapp.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jobsapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}