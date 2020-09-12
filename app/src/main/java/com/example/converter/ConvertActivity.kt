package com.example.converter

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_display.*
import kotlinx.android.synthetic.main.fragment_keyboard.*


class ConvertActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

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
        input_spinner.onItemSelectedListener = this
        output_spinner.onItemSelectedListener = this

        editViewModel.inputEditLiveData.observe(this, Observer {
            input_edit.setText(it)
        })

        editViewModel.outputEditLiveData.observe(this, Observer {
            output_edit.setText(it)
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
            editViewModel.inputEditLiveData.value += "0"
        }

        one_button.setOnClickListener(){
            editViewModel.inputEditLiveData.value += "1"
        }

        two_button.setOnClickListener(){
            editViewModel.inputEditLiveData.value += "2"
        }

        three_button.setOnClickListener(){
            editViewModel.inputEditLiveData.value += "3"
        }

        four_button.setOnClickListener(){
            editViewModel.inputEditLiveData.value += "4"
        }

        five_button.setOnClickListener(){
            editViewModel.inputEditLiveData.value += "5"
        }

        six_button.setOnClickListener(){
            editViewModel.inputEditLiveData.value += "6"
        }

        seven_button.setOnClickListener(){
            editViewModel.inputEditLiveData.value += "7"
        }

        eight_button.setOnClickListener(){
            editViewModel.inputEditLiveData.value += "8"
        }

        nine_button.setOnClickListener(){
            editViewModel.inputEditLiveData.value += "9"
        }

        point_button.setOnClickListener(){
            if(editViewModel.inputEditLiveData.value != "" && editViewModel.inputEditLiveData.value!!.indexOf(".") <= 1)
            {
                editViewModel.inputEditLiveData.value += "."
            }
        }

        clear_button.setOnClickListener(){
            editViewModel.inputEditLiveData.value = ""
        }

        convert_button.setOnClickListener()
        {
            spinnerViewModel.liveInputItem.value = input_spinner.selectedItem.toString()
            spinnerViewModel.liveOutputItem.value = output_spinner.selectedItem.toString()
            editViewModel.outputEditLiveData.value = String.format("%.3f\n", (editViewModel.inputEditLiveData.value!!.toDouble() * spinnerViewModel.getCoefficient()))
        }


    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        spinnerViewModel.liveInputItem.value = input_spinner.selectedItem.toString()
        spinnerViewModel.liveOutputItem.value = output_spinner.selectedItem.toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }
}