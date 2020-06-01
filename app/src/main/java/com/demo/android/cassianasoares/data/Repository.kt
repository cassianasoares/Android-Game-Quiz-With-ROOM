package com.demo.android.cassianasoares.data

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.demo.android.cassianasoares.QuizApplication
import com.demo.android.cassianasoares.data.db.QuizDao
import com.demo.android.cassianasoares.data.model.Answer
import com.demo.android.cassianasoares.data.model.Question
import com.demo.android.cassianasoares.data.model.QuestionAndAllAnswers

class Repository : QuizRepository {

    private val quizDao: QuizDao by lazy {
        QuizApplication.database.quizDao()
    }
    private val allQuestions by lazy { quizDao.getAllQuestions() }
    private val allQuestionsAndAllAnswers by lazy {
        quizDao.getQuestionAndAllAnswers() }

    override fun getSavedQuestions(): LiveData<List<Question>> {
        return allQuestions
    }

    override fun saveQuestion(question: Question) {
        AsyncTask.execute{quizDao.insert(question)}
    }

    override fun saveAnswer(answer: Answer) {
        AsyncTask.execute{quizDao.insert(answer)}
    }

    override fun getQuestionAndAllAnswers(): LiveData<List<QuestionAndAllAnswers>> {
        return allQuestionsAndAllAnswers
    }

    override fun deleteQuestions() {
        AsyncTask.execute { quizDao.clearQuestions() }
    }
}