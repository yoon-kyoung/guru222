package com.example.myapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBManager(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        //db!!.execSQL("CREATE TABLE memory(subject text, nation text, friend text, record text, start_date text, end_date text)")
        //db!!.execSQL("CREATE TABLE memory(subject text, nation text, friend text, record text)")
        db!!.execSQL("CREATE TABLE memory(subject text, nation text, friend text, record text, date text)")

        //버튼색상
        db!!.execSQL("CREATE TABLE memory_color(subject TEXT PRIMARY KEY, color INTEGER)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}