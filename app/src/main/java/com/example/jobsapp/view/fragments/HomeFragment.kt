package com.example.jobsapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jobsapp.R
import com.example.jobsapp.data.utilities.Status
import com.example.jobsapp.databinding.FragmentHomeBinding
import com.example.jobsapp.view.adapters.HomeAdapter
import com.example.jobsapp.viewModel.HomeFragmentViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeFragmentViewModel : HomeFragmentViewModel by viewModels()
    private lateinit var homeAdapter : HomeAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        val view = binding.root
        homeFragmentViewModel.res.observe(requireActivity(), Observer {
            when(it.status) {
                Status.SUCCESS -> {
                    binding.progress.visibility = View.GONE
                    binding.homeRecyclerView.visibility = View.VISIBLE
                    it.data.let { res ->
                        homeAdapter = HomeAdapter(requireContext(), res!!)
                        binding.homeRecyclerView.layoutManager = LinearLayoutManager(requireContext())
                        binding.homeRecyclerView.adapter = homeAdapter

                    }
                }

                Status.LOADING -> {
                    binding.progress.visibility = View.VISIBLE
                    binding.homeRecyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    binding.progress.visibility = View.GONE
                    binding.homeRecyclerView.visibility = View.VISIBLE
                    Snackbar.make(binding.root, "Something went wrong", Snackbar.LENGTH_SHORT)
                        .show()
                }
            }})
        return view
    }



}