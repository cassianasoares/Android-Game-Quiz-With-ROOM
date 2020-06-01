package com.demo.android.cassianasoares.data.db.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration3To4: Migration(3, 4) {

    //Migração de banco de dados quando alterar uma coluna já existente
    override fun migrate(database: SupportSQLiteDatabase) {
        //criar uma nova table temporaria com as modificações
        database.execSQL("CREATE TABLE questions_new (question_id INTEGER NOT NULL," +
                "text TEXT NOT NULL, " +
                "difficulty TEXT NOT NULL, " +
                "category TEXT NOT NULL, " +
                "PRIMARY KEY (question_id))"
        )

        //criando um index para a nova table
        database.execSQL("CREATE INDEX index_questions_new_question_id ON questions_new(question_id)")

        //Copiando os dados da table velha para a nova
        database.execSQL("INSERT INTO questions_new (question_id, text, difficulty, category) SELECT question_id, text, difficulty, category FROM questions")

        //Excluindo a table velha
        database.execSQL("DROP TABLE questions")

        //mudando o nome da table nova para o nome da velha
        database.execSQL("ALTER TABLE questions_new RENAME TO questions")
    }
}