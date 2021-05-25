package com.example.jobsapp.data.retrofit

import com.example.jobsapp.data.model.JobModel
import retrofit2.Response
import javax.inject.Inject

class JobsApiHelperImpl @Inject constructor(private val jobsApiService: JobsApiService) :JobsApiHelper{

    override suspend fun getJobs(description: String): Response<JobModel> = jobsApiService.getJobs("api")

}