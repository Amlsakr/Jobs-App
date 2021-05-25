package com.example.jobsapp.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jobsapp.data.model.JobModel
import com.example.jobsapp.databinding.JobItemBinding
import com.example.jobsapp.view.fragments.ItemClickListener

class HomeAdapter (val context : Context,var jobList : List<JobModel> , val itemClickListener : ItemClickListener)
    : RecyclerView.Adapter<HomeAdapter.JobsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobsViewHolder {
        val jobItemViewBinding =
            JobItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JobsViewHolder(jobItemViewBinding)
    }

    override fun onBindViewHolder(holder: JobsViewHolder, position: Int) {

        holder.jobItemBinding.companyName.text = jobList.get(position).company
        holder.jobItemBinding.jobTitle.text = jobList.get(position).title
        Glide.with(context).load(jobList.get(position).companyLogo).into(holder.jobItemBinding.companyLogo)
        holder.jobItemBinding.holder.setOnClickListener {
            itemClickListener.onClick(jobList.get(position))
        }

    }

    override fun getItemCount(): Int = jobList.size

    inner class JobsViewHolder (var jobItemBinding: JobItemBinding )
        :RecyclerView.ViewHolder (jobItemBinding.root){

    }
}