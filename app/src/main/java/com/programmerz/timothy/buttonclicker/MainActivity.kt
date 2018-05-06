package com.programmerz.timothy.buttonclicker

import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var correctButton: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        reset()
    }

    private fun reset() {
        startTimer()
        score.text = "0"
        correctButton = 0
    }
    
    private fun startTimer() {
        val timer = object: CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                time.text = (millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {
                time.text = "Game Over!"
            }
        }
        timer.start()
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.button1 -> {
                Toast.makeText(this, "button 1 was clicked!", Toast.LENGTH_SHORT).show()
            }
            R.id.button2 -> {
                Toast.makeText(this, "button 2 was clicked!", Toast.LENGTH_SHORT).show()
            }
            R.id.button3 -> {
                Toast.makeText(this, "button 3 was clicked!", Toast.LENGTH_SHORT).show()
            }
            R.id.button4 -> {
                Toast.makeText(this, "button 4 was clicked!", Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(this, "Critical mistakes were made...", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
