package com.demo.android.cassianasoares.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.demo.android.cassianasoares.R
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val score = intent.extras?.getInt("SCORE")
        val numberOfQuestions =  intent.extras?.getInt("NUMBER_OF_QUESTIONS")
        scoreTextView.text = "You scored: " + score.toString() + "/"+ numberOfQuestions.toString()
    }

    fun startAgain(view: View) {
        startActivity(Intent(this, QuestionActivity::class.java))
    }

    fun backToHome(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }
}