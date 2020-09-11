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
    lateinit var spinnerViewModel: SpinnerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_convert)
        editViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        spinnerViewModel = ViewModelProvider(this, SpinnerFactory(application,
            intent.getStringExtra("token").toString())).get(SpinnerViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                spinnerViewModel.liveData.value!!
            )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        editViewModel.liveData.observe(this, Observer {
            input_edit.setText(it)
        })

        spinnerViewModel.liveData.observe(this, Observer {
            input_spinner.setAdapter(adapter)
            output_spinner.setAdapter(adapter)
        })

        spinnerViewModel.liveInputItem.observe(this, Observer {
            input_spinner.setSelection(adapter.getPosition(it!!))
        })

        spinnerViewModel.liveOutputItem.observe(this, Observer {
            output_spinner.setSelection(adapter.getPosition(it!!))
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

        convert_button.setOnClickListener()
        {
            spinnerViewModel.liveInputItem.value = input_spinner.getSelectedItem().toString()
            spinnerViewModel.liveOutputItem.value = output_spinner.getSelectedItem().toString()
            output_edit.setText(String.format("%.3f\n", (editViewModel.liveData.value!!.toDouble() * spinnerViewModel.getCoefficient())))
        }
    }
}