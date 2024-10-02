package com.example.rovers.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.rovers.Photos
import com.example.rovers.repository.MarsRepository

class PhotoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MarsRepository

    fun getMarsPhotoList() : MutableLiveData<List<Photos.MarsPhoto>>{
        return repository.marsInfoLiveData
    }

    public fun requestData() {
        repository.getNasaInfo()
    }

}