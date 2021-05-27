package com.example.jobsapp.data.repository

import com.example.jobsapp.data.local.JobRoomDatabase
import com.example.jobsapp.data.model.JobModel
import com.example.jobsapp.data.retrofit.JobsApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val jobsApiHelper: JobsApiHelper, private val db: JobRoomDatabase) {

    suspend fun getJobsFomInternet() = jobsApiHelper.getJobs("api")

    val dao = db.jobDao()

    suspend fun updateJob(id: String, isFavorite: Int) {
        dao.updateJob(id, isFavorite)
    }

    suspend fun insertAll(jobItem: List<JobModel>): List<Long> {
        val array = dao.insertAll(jobItem)
        return array
    }

    suspend fun getAll(): List<JobModel> {
        return dao.getAllJobs()
    }

    suspend fun exists(id: String): Boolean {
        return dao.exists(id)
    }

    suspend fun insertItem(jobItem: JobModel) {
        dao.insert(jobItem)
    }

}