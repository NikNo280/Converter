package com.example.converter

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class SpinnerViewModel(application: Application, val token:String):AndroidViewModel(application) {
    val liveData = MutableLiveData<Array<String>>()
    val liveInputItem = MutableLiveData<String>()
    val liveOutputItem = MutableLiveData<String>()

    init {
        val spinnerArray :Array<String>
        if(token == "distance")
        {
            spinnerArray = arrayOf("Meters", "Kilometers", "Miles")
        }
        else if(token == "weight")
        {
            spinnerArray = arrayOf("Grams", "Kilograms", "Pounds")
        }
        else
        {
            spinnerArray = arrayOf("Rubles", "Dollars", "Euro")
        }
        liveData.value = spinnerArray
    }
    fun getCoefficient():Double
    {
        val inputCoefficient:Double
        val outputCoefficient:Double

        when(liveInputItem.value) {
            "Meters", "Grams", "Rubles" -> inputCoefficient = 1.0
            "Kilometers", "Kilograms" -> inputCoefficient = 1000.0
            "Miles" -> inputCoefficient = 1609.64
            "Pounds" -> inputCoefficient = 453.592
            "Dollars" -> inputCoefficient = 2.62
            "Euro" -> inputCoefficient = 3.09
            else ->inputCoefficient = 1.0
        }

        when(liveOutputItem.value) {
            "Meters", "Grams", "Rubles" -> outputCoefficient = 1.0
            "Kilometers", "Kilograms" -> outputCoefficient = 1000.0
            "Miles" -> outputCoefficient = 1609.64
            "Pounds" -> outputCoefficient = 453.592
            "Dollars" -> outputCoefficient = 2.62
            "Euro" -> outputCoefficient = 3.09
            else ->outputCoefficient = 1.0
        }
        return inputCoefficient/outputCoefficient
    }


}