package com.example.jobsapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jobsapp.data.model.JobModel
import com.example.jobsapp.data.repository.MainRepository
import com.example.jobsapp.data.utilities.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel  @Inject constructor(private val mainRepository : MainRepository): ViewModel(){

    private val _res = MutableLiveData<Resource<List<JobModel>>>()

    val res : LiveData<Resource<List<JobModel>>>
    get() = _res

    init {
        getJobs()
    }

    private fun getJobs() = viewModelScope.launch {
        _res.postValue(Resource.loading(null))
        mainRepository.getJobsFomInternet().let {
            if(it.isSuccessful){
                _res.postValue(Resource.success(it.body()))
            }else {
                _res.postValue(Resource.error(it.errorBody().toString(), null))
            }
        }
    }
}