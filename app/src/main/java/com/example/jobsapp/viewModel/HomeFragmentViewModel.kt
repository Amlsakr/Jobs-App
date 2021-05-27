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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {
    private val _res = MutableLiveData<Resource<List<JobModel>>>()
    val res: LiveData<Resource<List<JobModel>>>
        get() = _res

    private val _local = MutableLiveData<List<JobModel>>()
    val local: LiveData<List<JobModel>>
        get() = _local

    init {
        getJobsFromInternet()
    }

    private fun getJobsFromInternet() = viewModelScope.launch(Dispatchers.IO) {
        _res.postValue(Resource.loading(null))
        mainRepository.getJobsFomInternet().let {
            if (it.isSuccessful) {
                it.body()?.let { it1 ->
                    val listFromDB = getJobsFromDataBase()
                    if (listFromDB.size <= 0) {
                        mainRepository.insertAll(it1)
                        getJobsFromDataBase()
                    } else {
                        for (item in it1) {
                            var exist = mainRepository.exists(item.id)
                            if (!exist) {
                                mainRepository.insertItem(item)
                            }
                        }
                        getJobsFromDataBase()
                    }
                }
                _res.postValue(Resource.success(it.body()))
            } else {
                _res.postValue(Resource.error(it.errorBody().toString(), null))
            }
        }
    }

    private suspend fun getJobsFromDataBase(): ArrayList<JobModel> {
        var list: ArrayList<JobModel> = arrayListOf()
        _res.postValue(Resource.loading(null))
        mainRepository.getAll().let {
            Log.e("tag", "size of array from DB" + it.size)
            _local.postValue(it)
            list = it as ArrayList<JobModel>
        }
        return list
    }

    fun updateItem(id: String, isFavorite: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.updateJob(id, isFavorite)
        }
    }

}
