package com.demo.android.cassianasoares.data.model

sealed class QuizState {

    object LoadingState : QuizState()
    data class DataState(val data: QuestionAndAllAnswers): QuizState()
    object EmptyState : QuizState()
    data class FinishState(val numberOfQuestions: Int, val score: Int) : QuizState()

}