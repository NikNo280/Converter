package com.example.converter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_choise.*


class ChoiseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choise, container, false)
    }

    override fun onStart() {
        super.onStart()
        distance_button.setOnClickListener()
        {
            (activity as MainActivity).navController.navigate(R.id.action_choiseFragment_to_convertActivity)
        }
        weight_button.setOnClickListener()
        {
            (activity as MainActivity).navController.navigate(R.id.action_choiseFragment_to_convertActivity)
        }
        currency_button.setOnClickListener()
        {
            (activity as MainActivity).navController.navigate(R.id.action_choiseFragment_to_convertActivity)
        }
    }

}