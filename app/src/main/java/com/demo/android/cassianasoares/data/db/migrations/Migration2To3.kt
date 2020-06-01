package com.demo.android.cassianasoares.data.db.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration2To3: Migration(2, 3) {

    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE questions ADD COLUMN category TEXT NOT NULL DEFAULT 'android'")
    }
}