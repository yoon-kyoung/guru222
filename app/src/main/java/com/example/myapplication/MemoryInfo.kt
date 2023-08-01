package com.example.myapplication

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MemoryInfo:AppCompatActivity() {

    lateinit var dbManager:DBManager
    lateinit var sqlitedb:SQLiteDatabase

    lateinit var tvSubject: TextView
    lateinit var tvNation: TextView
    lateinit var tvFriend: TextView
    lateinit var tvRecord: TextView
    lateinit var tvDate: TextView

    lateinit var str_subject:String
    lateinit var str_nation:String
    lateinit var str_friend:String
    lateinit var str_record:String
    lateinit var str_date:String
    lateinit var listbtn: Button
    lateinit var deletebtn:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.memoryinfo)

        tvSubject=findViewById(R.id.mt3)
        tvNation=findViewById(R.id.mt5)
        tvFriend=findViewById(R.id.mt8)
        tvRecord=findViewById(R.id.mt15)
        tvDate=findViewById(R.id.mtt)
        listbtn=findViewById(R.id.mtbtn1)
        deletebtn=findViewById(R.id.deletebtn)
        var back=findViewById<ImageView>(R.id.closeIcon)

        back.setOnClickListener{
            val intent1= Intent(this,MemoryItem::class.java)
            startActivity(intent1)
        }

        listbtn.setOnClickListener{
            val intent1= Intent(this,MemoryItem::class.java)
            startActivity(intent1)
        }

        // 메모리 버튼들
        val buttonMT10 = findViewById<Button>(R.id.mt10)
        val buttonMT11 = findViewById<Button>(R.id.mt11)
        val buttonMT12 = findViewById<Button>(R.id.mt12)
        val buttonMT13 = findViewById<Button>(R.id.mt13)
        val buttonMT14 = findViewById<Button>(R.id.mt14)

        val intent=intent
        str_subject=intent.getStringExtra("intent_subject").toString()
        dbManager= DBManager(this,"memoryDB",null,1)
        sqlitedb=dbManager.readableDatabase

        /*deletebtn.setOnClickListener{
            sqlitedb.execSQL("DELETE FROM memory WHERE subject = '"+ str_subject + "';")
            val intent=Intent(this,MemoryItem::class.java)
            startActivity(intent)

        }*/
        // MT10 버튼 색상 설정
        setMemoryButtonColor(buttonMT10, "mt10", sqlitedb)

        // MT11 버튼 색상 설정
        setMemoryButtonColor(buttonMT11, "mt11", sqlitedb)

        // MT12 버튼 색상 설정
        setMemoryButtonColor(buttonMT12, "mt12", sqlitedb)

        // MT13 버튼 색상 설정
        setMemoryButtonColor(buttonMT13, "mt13", sqlitedb)

        // MT14 버튼 색상 설정
        setMemoryButtonColor(buttonMT14, "mt14", sqlitedb)

        var cursor:Cursor
        cursor=sqlitedb.rawQuery("SELECT * FROM memory WHERE subject='"+str_subject+"';",null)

        if(cursor.moveToNext()){
            val columnIndex = cursor.getColumnIndex("nation")
            str_nation = cursor.getString(columnIndex).toString()
            val columnIndex2 = cursor.getColumnIndex("friend")
            str_friend = cursor.getString(columnIndex2).toString()
            val columnIndex3 = cursor.getColumnIndex("record")
            str_record = cursor.getString(columnIndex3).toString()
            val columnIndex4 = cursor.getColumnIndex("date")
            str_date = cursor.getString(columnIndex4).toString()

        }
        cursor.close()
        sqlitedb.close()
        dbManager.close()

        tvSubject.text=str_subject
        tvNation.text=str_nation
        tvFriend.text=str_friend
        tvRecord.text=str_record
        tvDate.text=str_date
    }
    private fun setMemoryButtonColor(button: Button, subject: String, sqlitedb: SQLiteDatabase) {
        val cursor = sqlitedb.rawQuery("SELECT * FROM memory_color WHERE subject='$subject'", null)
        if (cursor.moveToFirst()) {
            val colorIndex = cursor.getColumnIndex("color")
            if (colorIndex != -1) {
                val color = cursor.getInt(colorIndex)
                if (color == Color.parseColor("#F3F7DE")) {
                    button.isSelected = true
                    button.setBackgroundColor(Color.parseColor("#F3F7DE"))
                } else {
                    button.isSelected = false
                    button.setBackgroundColor(Color.parseColor("#F4F4F4"))
                }
            }
        }
        cursor.close()
    }

}