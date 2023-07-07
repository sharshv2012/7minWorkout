package com.example.a7minworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.example.a7minworkout.databinding.ActivityExcerciseBinding
import com.example.a7minworkout.databinding.ActivityMainBinding

class ExcerciseActivity : AppCompatActivity() {
    private var binding : ActivityExcerciseBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityExcerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarExcercise)

        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)//When you call setDisplayHomeAsUpEnabled(true), it enables the display of the "Up" button in the action bar or toolbar. This button typically appears as a left-facing arrow or a custom icon representing navigation or going back.
        }

        binding?.toolbarExcercise?.setNavigationOnClickListener{
           onBackPressedDispatcher.onBackPressed()
        }


    }
}