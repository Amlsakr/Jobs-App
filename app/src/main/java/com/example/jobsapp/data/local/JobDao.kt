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
 suspend   fun getAllJobs() : List<JobModel>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(jobItems: List<JobModel>) : List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(jobItem: JobModel)

    @Query("UPDATE job_table SET isfavourit = :isFavorite WHERE id = :id")
   suspend fun updateJob(id: String, isFavorite: Int): Int

    @Query("SELECT EXISTS (SELECT 1 FROM job_table WHERE id = :id)")
    fun exists(id: String): Boolean

}