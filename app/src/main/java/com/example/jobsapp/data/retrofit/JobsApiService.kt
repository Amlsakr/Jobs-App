package com.example.jobsapp.data.retrofit

import com.example.jobsapp.data.model.JobModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JobsApiService {
    @GET("positions.json")
    suspend fun getJobs(@Query("description")  description : String): Response<List<JobModel>>
}