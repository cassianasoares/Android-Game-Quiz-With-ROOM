package com.demo.android.cassianasoares.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.core.view.forEachIndexed
import androidx.lifecycle.Observer
import com.demo.android.cassianasoares.R
import com.demo.android.cassianasoares.data.Repository
import com.demo.android.cassianasoares.data.model.QuizState
import com.demo.android.cassianasoares.viewModel.QuizViewModel
import kotlinx.android.synthetic.main.activity_questions.*
import org.jetbrains.anko.clearTask
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.newTask

class QuestionActivity : AppCompatActivity() {

    private val viewModel by lazy { QuizViewModel(Repository()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        getQuestionsAndAnswers()
        lv_block.setViewColor(Color.rgb(239, 88, 150));
        lv_block.setShadowColor(Color.BLACK)
    }

    private fun render(state: QuizState){
        when(state){
            is QuizState.EmptyState -> renderEmptyState()
            is QuizState.DataState -> renderDataState(state)
            is QuizState.FinishState -> goToResultActivity(state.numberOfQuestions, state.score)
            is QuizState.LoadingState -> renderLoadingState()
        }
    }

    private fun renderLoadingState() {
        loading_layout.visibility = View.VISIBLE
        lv_block.startAnim()
    }


    private fun renderDataState(quizState: QuizState.DataState) {
        lv_block.stopAnim()
        loading_layout.visibility = View.GONE
        displayQuestionsView()
        questionsRadioGroup.clearCheck()
        questionTextView.text = quizState.data.question?.text
        questionsRadioGroup.forEachIndexed { index, view ->
            if (index < quizState.data.answers.size)
                (view as RadioButton).text = quizState.data.answers[index].text
        }
    }


    private fun renderEmptyState() {
        empty_layout.visibility = View.VISIBLE
    }


    fun nextquestion(view: View) {
        val radioButton = findViewById<RadioButton>(questionsRadioGroup.checkedRadioButtonId)
        val selectedOption = questionsRadioGroup.indexOfChild(radioButton)
        viewModel.nextQuestion(selectedOption)
    }


    private fun displayQuestionsView() {
        question_layout.visibility = View.VISIBLE
    }


    private fun goToResultActivity(numberOfQuestions: Int, score: Int) {

        startActivity(
            intentFor<ResultActivity>(
                "SCORE" to score,
                "NUMBER_OF_QUESTIONS" to numberOfQuestions
            ).newTask().clearTask()
        )
    }

    private fun getQuestionsAndAnswers(){
        viewModel.getCurrentState().observe(this, Observer {
            render(it)
        })
    }

}
