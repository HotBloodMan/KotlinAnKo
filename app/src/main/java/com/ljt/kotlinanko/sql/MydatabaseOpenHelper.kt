package com.ljt.kotlinanko.sql

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class MydatabaseOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx,"MyDatabase",null,1) {

    companion object {
        private var instance: MydatabaseOpenHelper? = null


    @Synchronized
    fun getInstance(ctx: Context): MydatabaseOpenHelper {
        if (instance == null) {
            instance = MydatabaseOpenHelper(ctx.getApplicationContext())
        }
        return instance!!
    }
}

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable("Customer",true,"id" to INTEGER+ PRIMARY_KEY+ UNIQUE,"name" to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable("Customer",true)
    }

}

val Context.database:MydatabaseOpenHelper
    get()=MydatabaseOpenHelper.getInstance(getApplicationContext())