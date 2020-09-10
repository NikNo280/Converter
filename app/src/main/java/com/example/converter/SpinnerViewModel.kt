package com.example.converter

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class SpinnerViewModel(application: Application, val token:String):AndroidViewModel(application) {
    val liveData = MutableLiveData<Array<String>>()

    init {
        val spinnerArray :Array<String>
        if(token == "distance")
        {
            spinnerArray = arrayOf("Kil", "met", "ant")
        }
        else if(token == "weight")
        {
            spinnerArray = arrayOf("il", "et", "nt")
        }
        else
        {
            spinnerArray = arrayOf("l", "t", "t")
        }
        liveData.value = spinnerArray
    }
}