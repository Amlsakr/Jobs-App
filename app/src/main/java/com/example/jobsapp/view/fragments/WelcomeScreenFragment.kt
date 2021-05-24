package com.example.jobsapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.jobsapp.R
import com.example.jobsapp.databinding.FragmentWelcomeScreenBinding


class WelcomeScreenFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeScreenBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentWelcomeScreenBinding.inflate(layoutInflater)
        val view = binding.root

        binding.startButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_welcomeScreenFragment_to_homeFragment)
        }
        return view
    }


}