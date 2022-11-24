package com.example.gerenciadordeprodutos.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase

class DbGateway private constructor(ctx: Context) {
    val database: SQLiteDatabase

    companion object {
        private var gw: DbGateway? = null
        fun getInstance(ctx: Context): DbGateway? {
            if (gw == null) {
                gw = DbGateway(ctx)
            }
            return gw
        }
    }

    init {
        val helper = SQLiteHelper(ctx)
        database = helper.writableDatabase
    }
}