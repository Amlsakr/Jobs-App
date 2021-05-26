package com.example.jobsapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jobsapp.data.model.JobModel

@Database(entities = arrayOf(JobModel::class ) , version = 1 ,exportSchema = false)
 abstract class JobRoomDatabase : RoomDatabase() {

     abstract fun jobDao () : JobDao
     companion object{

         @Volatile
         private var INSTANCE : JobRoomDatabase? = null

         fun getDataBase (context : Context) : JobRoomDatabase{
             return INSTANCE ?: synchronized(this){
                 val instance = Room.databaseBuilder(context.applicationContext , JobRoomDatabase::class.java , "job_database" )
                         .build()
                 INSTANCE = instance
                 instance
             }

         }
     }
}