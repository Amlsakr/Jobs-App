package com.example.jobsapp.data.retrofit

import com.example.jobsapp.data.model.JobModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JobsApiHelper {


    suspend fun getJobs(@Query("description")  description : String): Response<JobModel>
}