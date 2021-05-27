package com.example.jobsapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jobsapp.data.model.JobModel
import com.example.jobsapp.databinding.FragmentHomeBinding
import com.example.jobsapp.view.adapters.HomeAdapter
import com.example.jobsapp.viewModel.HomeFragmentViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), ItemClickListener {

    private lateinit var binding: FragmentHomeBinding
    private val homeFragmentViewModel: HomeFragmentViewModel by viewModels()
    private lateinit var homeAdapter: HomeAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        val view = binding.root
        homeFragmentViewModel.local.observe(requireActivity(), Observer {
            it.let { res ->
                if (res != null) {
                    binding.progress.visibility = View.GONE
                    binding.homeRecyclerView.visibility = View.VISIBLE
                    homeAdapter = HomeAdapter(requireContext(), res, this)
                    binding.homeRecyclerView.layoutManager = LinearLayoutManager(requireContext())
                    binding.homeRecyclerView.adapter = homeAdapter
                } else {
                    Snackbar.make(binding.root, "Something went wrong", Snackbar.LENGTH_SHORT)
                            .show()
                }
            }
        })
        return view
    }

    override fun onClick(jobItem: JobModel) {

        val action = HomeFragmentDirections.actionHomeFragmentToJobDetailsFragment(jobItem)
        view?.findNavController()?.navigate(action)
    }

    override fun onClickFaviourit(jobItem: JobModel, isFavourit: Int) {
        homeFragmentViewModel.updateItem(jobItem.id, isFavourit)
    }


}