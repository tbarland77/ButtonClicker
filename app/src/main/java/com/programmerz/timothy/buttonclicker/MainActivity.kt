package com.programmerz.timothy.buttonclicker

import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var correctButton: Int = 0
    private var userScore: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        reset()
    }

    private fun reset() {
        generateRandom()
        startTimer()
        score.text = "0"
    }

    private fun generateRandom() {
        correctButton = Random().nextInt(3)
    }

    private fun resetColor(view: View) {
        view.setBackgroundResource(R.color.colorPrimary)
    }
    
    private fun startTimer() {
        val timer = object: CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                time.text = (millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {
                time.text = getString(R.string.game_over)
                reset()
            }
        }
        timer.start()
    }

    private fun startResetButtonColorTimer(view: View) {
        val timer = object: CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                resetColor(view)
            }
        }
        timer.start()
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.button1 -> {
              checkFirstButton(view)
            }
            R.id.button2 -> {
              checkSecondButton(view)
            }
            R.id.button3 -> {
                checkThirdButton(view)
            }
            R.id.button4 -> {
                checkForthButton(view)
            }
            else -> {
                Toast.makeText(this, "Critical mistakes were made...", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkFirstButton(view: View) {
        if (correctButton == 0) {
            view.setBackgroundResource(R.color.green_A700)
            userScore++
            score.text = userScore.toString()
        } else {
            view.setBackgroundResource(R.color.red_A700)
            incorrect()
        }
        generateRandom()
        startResetButtonColorTimer(view)
    }

    private fun checkSecondButton(view: View) {
        if (correctButton == 1) {
            view.setBackgroundResource(R.color.green_A700)
            userScore++
            score.text = userScore.toString()
        } else {
            view.setBackgroundResource(R.color.red_A700)
            incorrect()
        }
        generateRandom()
        startResetButtonColorTimer(view)
    }

    private fun checkThirdButton(view: View) {
        if (correctButton == 2) {
            view.setBackgroundResource(R.color.green_A700)
            userScore++
            score.text = userScore.toString()
        } else {
            view.setBackgroundResource(R.color.red_A700)
            incorrect()
        }
        generateRandom()
        startResetButtonColorTimer(view)
    }

    private fun checkForthButton(view: View) {
        if (correctButton == 3) {
            view.setBackgroundResource(R.color.green_A700)
            userScore++
            score.text = userScore.toString()
        } else {
            view.setBackgroundResource(R.color.red_A700)
            incorrect()
        }
        generateRandom()
        startResetButtonColorTimer(view)
    }

    private fun incorrect() {
        Toast.makeText(this, "You clicked the wrong button!", Toast.LENGTH_SHORT).show()
    }

}
