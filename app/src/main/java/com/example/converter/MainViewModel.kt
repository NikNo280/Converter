package com.example.converter


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application):AndroidViewModel(application) {

    val liveData = MutableLiveData<String>()
    init {
        liveData.value = ""
    }
}