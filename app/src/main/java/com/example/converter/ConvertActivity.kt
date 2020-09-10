package com.example.converter

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_display.*
import kotlinx.android.synthetic.main.fragment_keyboard.*


class ConvertActivity : AppCompatActivity() {

    lateinit var editViewModel: MainViewModel
    lateinit var spinnerViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_convert)
        editViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        //TODO
        val spinnerArray :Array<String>

        val token = intent.getStringExtra("token")
        println(token)
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
        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Применяем адаптер к элементу spinner
        input_spinner.setAdapter(adapter)
    }

    override fun onStart() {
        super.onStart()
        editViewModel.liveData.observe(this, Observer {
            input_edit.setText(it)
        })

        zero_button.setOnClickListener(){
            editViewModel.liveData.value += "0"
        }

        one_button.setOnClickListener(){
            editViewModel.liveData.value += "1"
        }

        two_button.setOnClickListener(){
            editViewModel.liveData.value += "2"
        }

        three_button.setOnClickListener(){
            editViewModel.liveData.value += "3"
        }

        four_button.setOnClickListener(){
            editViewModel.liveData.value += "4"
        }

        five_button.setOnClickListener(){
            editViewModel.liveData.value += "5"
        }

        six_button.setOnClickListener(){
            editViewModel.liveData.value += "6"
        }

        seven_button.setOnClickListener(){
            editViewModel.liveData.value += "7"
        }

        eight_button.setOnClickListener(){
            editViewModel.liveData.value += "8"
        }

        nine_button.setOnClickListener(){
            editViewModel.liveData.value += "9"
        }

        point_button.setOnClickListener(){
            editViewModel.liveData.value += "."
        }

        clear_button.setOnClickListener(){
            editViewModel.liveData.value = ""
        }

    }
}