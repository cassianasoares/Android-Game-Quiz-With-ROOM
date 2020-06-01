package com.demo.android.cassianasoares

import android.app.Application
import androidx.room.Room
import com.demo.android.cassianasoares.data.db.QuizDatabase

class QuizApplication : Application() {

    companion object{
        lateinit var database: QuizDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, QuizDatabase::class.java,
            "quiz_database").createFromAsset("database/DroidQuiz.db").addMigrations(QuizDatabase.MIGRATION_1_TO_2,
            QuizDatabase.MIGRATION_2_TO_3, QuizDatabase.MIGRATION_3_TO_4,
            QuizDatabase.MIGRATION_1_TO_4).build()
    }

}