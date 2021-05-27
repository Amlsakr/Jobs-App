package com.example.jobsapp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jobsapp.data.model.JobModel
import com.example.jobsapp.data.repository.MainRepository
import com.example.jobsapp.data.utilities.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.ArrayList
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel  @Inject constructor(private val mainRepository : MainRepository): ViewModel(){

    private val _res = MutableLiveData<Resource<List<JobModel>>>()
    val res : LiveData<Resource<List<JobModel>>>
    get() = _res

    private val _local = MutableLiveData<List<JobModel>>()
    val local :LiveData< List<JobModel>>
    get() = _local
    init {
        getJobsFromInternet()
     // getJobsFromDataBase()

    }




    private fun getJobsFromInternet() = viewModelScope.launch {
        _res.postValue(Resource.loading(null))
        mainRepository.getJobsFomInternet().let {
            if(it.isSuccessful){
                it.body()?.let { it1 ->

                    val listFromDB =  getJobsFromDataBase()
                    Log.e("taaggg" , listFromDB.size.toString() + "size " )

                        if (listFromDB.size <= 0) {
                            val array = mainRepository.insertAll(it1)
                       //     Log.e("TAG", "size array " + array.size)
                            getJobsFromDataBase()
                        }else {
                            for (item in it1){
                                var exist = mainRepository.exists(item.id)
                                if(!exist){
                                    mainRepository.insertItem(item)
                                }
                            }
                            getJobsFromDataBase()
                        }


                }


                _res.postValue(Resource.success(it.body()))
            }else {
                _res.postValue(Resource.error(it.errorBody().toString(), null))
            }
        }
    }


    private fun getJobsFromDataBase() : ArrayList<JobModel> {
        var list :  ArrayList<JobModel> = arrayListOf()
        viewModelScope.launch {
            _res.postValue(Resource.loading(null))
            mainRepository.getAll().let {
                Log.e("tag", "size of array from DB" + it.size)
                _local.postValue(it)
                list = it as ArrayList<JobModel>


            }
        }
        return list
    }
 fun updateItem(id :String , isFavorite : Int){
        viewModelScope.launch {
        mainRepository.updateJob(id , isFavorite)
    }
}

    }
