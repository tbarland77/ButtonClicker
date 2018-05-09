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
    
    private fun startTimer() {
        val timer = object: CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                time.text = (millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {
                time.text = getString(R.string.game_over)
            }
        }
        timer.start()
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.button1 -> {
              checkFirstButton()
            }
            R.id.button2 -> {
              checkSecondButton()
            }
            R.id.button3 -> {
                checkThirdButton()
            }
            R.id.button4 -> {
                checkForthButton()
            }
            else -> {
                Toast.makeText(this, "Critical mistakes were made...", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkFirstButton() {
        if (correctButton == 0) {
            userScore++
            score.text = userScore.toString()
        } else {
            incorrect()
        }
        generateRandom()
    }

    private fun checkSecondButton() {
        if (correctButton == 1) {
            userScore++
            score.text = userScore.toString()
        } else {
            incorrect()
        }
        generateRandom()
    }

    private fun checkThirdButton() {
        if (correctButton == 2) {
            userScore++
            score.text = userScore.toString()
        } else {
            incorrect()
        }
        generateRandom()
    }

    private fun checkForthButton() {
        if (correctButton == 3) {
            userScore++
            score.text = userScore.toString()
        } else {
            incorrect()
        }
        generateRandom()
    }

    private fun incorrect() {
        Toast.makeText(this, "You clicked the wrong button!", Toast.LENGTH_SHORT).show()
    }

}
