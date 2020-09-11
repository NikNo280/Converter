package com.example.converter


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application):AndroidViewModel(application) {

    val inputEditLiveData = MutableLiveData<String>()
    val outputEditLiveData = MutableLiveData<String>()
    init {
        inputEditLiveData.value = ""
        outputEditLiveData.value = ""
    }
}