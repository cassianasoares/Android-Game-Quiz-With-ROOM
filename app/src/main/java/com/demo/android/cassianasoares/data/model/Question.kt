package com.demo.android.cassianasoares.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "questions", indices = [Index("question_id")])
data class Question (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "question_id")
    var questionId: Int,
    val text: String,
    val difficulty: String = "0",
    val category: String = "android"
)