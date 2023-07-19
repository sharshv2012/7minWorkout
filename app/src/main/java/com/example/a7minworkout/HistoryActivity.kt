package com.example.a7minworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7minworkout.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {
    private var binding : ActivityHistoryBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarHistoryActivity)
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)//When you call setDisplayHomeAsUpEnabled(true), it enables the display of the "Up" button in the action bar or toolbar. This button typically appears as a left-facing arrow or a custom icon representing navigation or going back.
            supportActionBar?.title = "History"
        }
        binding?.toolbarHistoryActivity?.setNavigationOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }

    }
}