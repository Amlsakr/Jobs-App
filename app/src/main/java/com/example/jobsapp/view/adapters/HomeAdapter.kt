package com.example.jobsapp.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.jobsapp.R
import com.example.jobsapp.data.model.JobModel
import com.example.jobsapp.databinding.JobItemBinding
import com.example.jobsapp.view.fragments.ItemClickListener
import com.squareup.picasso.Picasso

class HomeAdapter(
        val context: Context,
        var jobList: List<JobModel>,
        val itemClickListener: ItemClickListener
) : RecyclerView.Adapter<HomeAdapter.JobsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobsViewHolder {
        val jobItemViewBinding =
                JobItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JobsViewHolder(jobItemViewBinding)
    }

    override fun onBindViewHolder(holder: JobsViewHolder, position: Int) {

        holder.jobItemBinding.companyName.text = jobList.get(position).company
        holder.jobItemBinding.jobTitle.text = jobList.get(position).title
        Picasso.get()
                .load(jobList.get(position).companyLogo)
                .into(holder.jobItemBinding.companyLogo)
        holder.jobItemBinding.holder.setOnClickListener {
            itemClickListener.onClick(jobList.get(position))
        }
        checkFavourit(jobList.get(position).isfavourit, holder)
        holder.jobItemBinding.favoriteJobIV.setOnClickListener {
            if (jobList.get(position).isfavourit == 1) {
                holder.jobItemBinding.favoriteJobIV.setImageResource(R.drawable.empty_favorite)
                jobList.get(position).isfavourit = 0
                notifyDataSetChanged()
                itemClickListener.onClickFaviourit(jobList.get(position), 0)
            } else {
                holder.jobItemBinding.favoriteJobIV.setImageResource(R.drawable.fill_favorite)
                jobList.get(position).isfavourit = 1
                notifyDataSetChanged()
                itemClickListener.onClickFaviourit(jobList.get(position), 1)
            }
        }
    }

    private fun checkFavourit(isfavourit: Int?, holder: JobsViewHolder) {
        if (isfavourit == 1) {
            holder.jobItemBinding.favoriteJobIV.setImageResource(R.drawable.fill_favorite)
        } else {
            holder.jobItemBinding.favoriteJobIV.setImageResource(R.drawable.empty_favorite)
        }
    }

    override fun getItemCount(): Int = jobList.size
    inner class JobsViewHolder(var jobItemBinding: JobItemBinding)
        : RecyclerView.ViewHolder(jobItemBinding.root)

}