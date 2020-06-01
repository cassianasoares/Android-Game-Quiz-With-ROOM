package com.demo.android.cassianasoares.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.demo.android.cassianasoares.data.db.migrations.Migration1To2
import com.demo.android.cassianasoares.data.db.migrations.Migration1To4
import com.demo.android.cassianasoares.data.db.migrations.Migration2To3
import com.demo.android.cassianasoares.data.db.migrations.Migration3To4
import com.demo.android.cassianasoares.data.model.Answer
import com.demo.android.cassianasoares.data.model.Question

@Database(entities = [(Question::class), (Answer::class)], version = 4)
abstract class QuizDatabase: RoomDatabase(){

    abstract fun quizDao(): QuizDao

    companion object{
        val MIGRATION_1_TO_2 = Migration1To2()
        val MIGRATION_2_TO_3 = Migration2To3()
        val MIGRATION_3_TO_4 = Migration3To4()
        val MIGRATION_1_TO_4 = Migration1To4()
    }

}