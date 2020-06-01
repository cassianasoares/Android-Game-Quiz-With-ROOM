package com.demo.android.cassianasoares.view

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
        progressBar.visibility = View.VISIBLE
    }


    private fun renderDataState(quizState: QuizState.DataState) {
        progressBar.visibility = View.GONE
        displayQuestionsView()
        questionsRadioGroup.clearCheck()
        questionTextView.text = quizState.data.question?.text
        questionsRadioGroup.forEachIndexed { index, view ->
            if (index < quizState.data.answers.size)
                (view as RadioButton).text = quizState.data.answers[index].text
        }
    }


    private fun renderEmptyState() {
        progressBar.visibility = View.GONE
        emptyDroid.visibility = View.VISIBLE
        emptyTextView.visibility = View.VISIBLE
    }


    fun nextquestion(view: View) {
        val radioButton = findViewById<RadioButton>(questionsRadioGroup.checkedRadioButtonId)
        val selectedOption = questionsRadioGroup.indexOfChild(radioButton)
        viewModel.nextQuestion(selectedOption)
    }


    private fun displayQuestionsView() {
        questionsRadioGroup.visibility = View.VISIBLE
        questionTextView.visibility = View.VISIBLE
        btn_next.visibility = View.VISIBLE
    }


    private fun goToResultActivity(numberOfQuestions: Int, score: Int) {
        /*val intent = Intent(this, QuestionActivity::class.java)
        intent.putExtra("SCORE", score)
        intent.putExtra("NUMBER_OF_QUESTIONS", numberOfQuestions)
        startActivity(intent).newTask()*/

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
