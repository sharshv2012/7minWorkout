package com.example.a7minworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.example.a7minworkout.databinding.ActivityExcerciseBinding
import com.example.a7minworkout.databinding.ActivityMainBinding

class ExcerciseActivity : AppCompatActivity() {
    private var binding : ActivityExcerciseBinding? = null
    private var restTimer : CountDownTimer? = null
    private var restProgress = 0
    private var exerciseTimer : CountDownTimer? = null
    private var exerciseProgress = 0
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
        // binding?.flTimer?.visibility = View.GONE will make the fl gone from the ui.
        //.INVISIBLE will make it invisible but thr fl would still have the space in ui.

        setUpRestView()


    }

    private fun setUpRestView(){// done so that if we go back to home then come gain timer will be reset.
        if(restTimer != null){
            restTimer?.cancel()
            restProgress = 0
        }
        setRestProgressBar()
    }
    private fun setUpExerciseView(){

        binding?.flTimer?.visibility = View.INVISIBLE
        binding?.tvTitle?.text = "PushUps"
        binding?.flTimerExcrcise?.visibility = View.VISIBLE
        if(exerciseTimer != null){
            exerciseTimer?.cancel()
            exerciseProgress = 0
        }
        setExerciseProgressBar()
    }

    private fun setRestProgressBar(){
        binding?.progressBar?.progress = restProgress
        restTimer = object : CountDownTimer(10000 , 1000){
            override fun onTick(p0 : Long) {
                restProgress++
                binding?.progressBar?.progress = 10 - restProgress
                binding?.tvTimer?.text = (10 - restProgress).toString()
            }

            override fun onFinish() {
                setUpExerciseView()
                Toast.makeText(this@ExcerciseActivity ,
                "Let's start our workout"
                ,Toast.LENGTH_SHORT).show()
            }
        }.start()
    }

    private fun setExerciseProgressBar(){
        binding?.progressBarExercise?.progress = exerciseProgress
        exerciseTimer = object : CountDownTimer(30000 , 1000){
            override fun onTick(p0 : Long) {
                exerciseProgress++
                binding?.progressBarExercise?.progress = 30 - exerciseProgress
                binding?.tvTimerExercise?.text = (30 - exerciseProgress).toString()
            }

            override fun onFinish() {
                Toast.makeText(this@ExcerciseActivity ,
                    "take some rest now"
                    ,Toast.LENGTH_SHORT).show()
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        if(restTimer != null){
            restTimer?.cancel()
            restProgress = 0
        }

        if(exerciseTimer != null){
            exerciseTimer?.cancel()
            exerciseProgress = 0
        }
        binding = null
    }

}