package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class Activity10_mbti: AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mbti1)

        val next = findViewById<AppCompatButton>(R.id.mbtistartbtn1)
        val pass=findViewById<TextView>(R.id.textView4)

        next.setOnClickListener {
            var intent = Intent(this, Activity11::class.java)
            startActivity(intent)
        }

        pass.setOnClickListener{
            var intent2 = Intent(this, MemoryItem::class.java)
            startActivity(intent2)
        }

    }
}