package com.example.myapplication

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.marginTop

class MemoryItem :AppCompatActivity(){
    lateinit var dbManager: DBManager
    lateinit var sqlitedb:SQLiteDatabase
    lateinit var layout:LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my1)
        // 추천 여행지 보러가기
        val next = findViewById<AppCompatButton>(R.id.mybtn1)
        val memoey = findViewById<Button>(R.id.mybtn2)

        /*next.setOnClickListener {
            var intent = Intent(this, Activity24::class.java) //searching으로 이동
            startActivity(intent)
        }*/

        memoey.setOnClickListener {
            var intent2 = Intent(this, Activity26::class.java)
            startActivity(intent2)
        }

        dbManager= DBManager(this,"memoryDB",null,1)
        sqlitedb=dbManager.readableDatabase

        layout=findViewById(R.id.memory)

        var cursor:Cursor
        cursor=sqlitedb.rawQuery("SELECT * FROM memory", null)

        var num:Int=0
        while(cursor.moveToNext()){
            val columnIndex1 = cursor.getColumnIndex("subject")
            var str_subject = cursor.getString(columnIndex1).toString()
            val columnIndex = cursor.getColumnIndex("nation")
            var str_nation = cursor.getString(columnIndex).toString()
            val columnIndex2 = cursor.getColumnIndex("friend")
            var str_friend = cursor.getString(columnIndex2).toString()
            val columnIndex3 = cursor.getColumnIndex("record")
            var str_record = cursor.getString(columnIndex3).toString()
            //val columnIndex4 = cursor.getColumnIndex("date")
           // var str_date = cursor.getString(columnIndex4).toString()

            var layout_item:LinearLayout= LinearLayout(this)
            layout_item.orientation=LinearLayout.VERTICAL
            layout_item.id=num


            var tvNation:TextView=TextView(this)
            tvNation.text=str_nation
            tvNation.textSize=16f
            layout_item.addView(tvNation)

            var tvSubject:TextView=TextView(this)
            tvSubject.text=str_subject
            tvSubject.textSize=16f
            layout_item.addView(tvSubject)


            layout_item.setOnClickListener{
                val intent = Intent(this,MemoryInfo::class.java)
                intent.putExtra("intent_subject",str_subject)
                startActivity(intent)
            }
            layout.addView(layout_item)
            num++;

        }

        cursor.close()
        sqlitedb.close()
        dbManager.close()

    }
}