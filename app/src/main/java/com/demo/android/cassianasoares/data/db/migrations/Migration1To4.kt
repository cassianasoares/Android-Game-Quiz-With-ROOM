package com.demo.android.cassianasoares.data.db.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration1To4: Migration(1, 4) {

    //Migrar banco de dados direto da versão 1 para a 4
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE questions ADD COLUMN difficulty TEXT NOT NULL DEFAULT'0'")
        database.execSQL("ALTER TABLE questions ADD COLUMN category TEXT NOT NULL DEFAULT'android'")
    }
}