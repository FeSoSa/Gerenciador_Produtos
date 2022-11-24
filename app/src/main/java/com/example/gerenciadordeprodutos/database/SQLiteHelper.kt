package com.example.gerenciadordeprodutos.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "produto.db"
        private const val SQL_DELETE_PRODUTO = "DROP TABLE IF EXISTS TBL_PRODUTO"
    }

    private val SQL_CREATE_PRODUTO = "CREATE TABLE TBL_PRODUTO ( " +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "NOMEPROD TEXT NOT NULL, " +
            "QUANTIDADE INTEGER, " +
            "PRECO DOUBLE );"


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_PRODUTO)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL(SQL_DELETE_PRODUTO)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
}
