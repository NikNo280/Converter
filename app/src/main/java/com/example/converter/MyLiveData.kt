package com.example.converter

import androidx.lifecycle.LiveData

class MyLiveData:LiveData<String>() {

    fun setMyValueToLiveData(string: String)
    {
        value = string
    }

}