package com.example.jobsapp.data.repository

import com.example.jobsapp.data.retrofit.JobsApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val jobsApiHelper: JobsApiHelper ) {

    suspend fun getJobsFomInternet () = jobsApiHelper.getJobs("api")

}