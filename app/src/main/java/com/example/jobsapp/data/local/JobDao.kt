package com.example.jobsapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.jobsapp.data.model.JobModel

@Dao
interface JobDao {
    @Query("SELECT * FROM job_table")
    fun getAllJobs() : LiveData<List<JobModel>>

    @Query("SELECT * FROM job_table WHERE id = :id")
    fun getJob(id: String): LiveData<JobModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(jobItems: List<JobModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(jobItem: JobModel)
}