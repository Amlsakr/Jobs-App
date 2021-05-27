package com.example.jobsapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jobsapp.R
import com.example.jobsapp.databinding.FragmentHomeBinding
import com.example.jobsapp.databinding.FragmentJobDetailsBinding
import com.squareup.picasso.Picasso


class JobDetailsFragment : Fragment() {

    private lateinit var binding: FragmentJobDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentJobDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        val model = JobDetailsFragmentArgs.fromBundle(requireArguments()).jobItem
        binding.companyName.text = model.company
        Picasso.get().load(model.companyLogo).into(binding.companyLogo)
        binding.jobTitle.text = model.title

        if (model.isfavourit == 1) {
           binding.favorite.setImageResource(R.drawable.fill_favorite)
        } else {
            binding.favorite.setImageResource(R.drawable.empty_favorite)

        }

        return view
    }


}