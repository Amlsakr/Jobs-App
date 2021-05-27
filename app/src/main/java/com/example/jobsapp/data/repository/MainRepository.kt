package com.example.jobsapp.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.jobsapp.data.local.JobDao
import com.example.jobsapp.data.local.JobRoomDatabase
import com.example.jobsapp.data.model.JobModel
import com.example.jobsapp.data.retrofit.JobsApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val jobsApiHelper: JobsApiHelper ,private val  db : JobRoomDatabase ) {

    suspend fun getJobsFomInternet () = jobsApiHelper.getJobs("api")

    val  dao = db.jobDao()
    suspend fun updateJob (id : String , isFavorite : Int) {
      dao.updateJob(id , isFavorite)
    }

    suspend fun insertAll (jobItem :List<JobModel>) : List<Long> {
        Log.e("TAG", "inside insert  " )
     val array =    dao.insertAll(jobItem)
       // Log.e("TAG", "insertAll: " +jobItem.toString())
        return array
    }

     suspend fun getAll() :List<JobModel>{
     return   dao.getAllJobs()
    }

    suspend fun exists (id : String ) : Boolean {
        return dao.exists(id)
    }

    suspend fun insertItem(jobItem : JobModel){
        dao.insert(jobItem)
    }

}