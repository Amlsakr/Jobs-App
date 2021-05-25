package com.example.jobsapp.view.fragments

import com.example.jobsapp.data.model.JobModel

interface ItemClickListener {
    fun onClick(jobItem :JobModel)
}