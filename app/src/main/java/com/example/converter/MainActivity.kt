package com.example.converter

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_choise.*

class MainActivity : AppCompatActivity() {
    lateinit var  navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.nav_host)
    }

    override fun onStart() {
        super.onStart()

        val intent = Intent(this, ConvertActivity::class.java)
        distance_button.setOnClickListener()
        {
            intent.putExtra("token", "distance")
            startActivity(intent)
        }
        weight_button.setOnClickListener()
        {
            intent.putExtra("token", "weight")
            startActivity(intent)
        }
        currency_button.setOnClickListener()
        {
            intent.putExtra("token", "currency")
            startActivity(intent)
        }
    }
}