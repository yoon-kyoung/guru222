package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class Activity17 : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mbti8)

        val next = findViewById<AppCompatButton>(R.id.mbtibtn2)

        next.setOnClickListener {
            var intent = Intent(this, Activity18::class.java)
            startActivity(intent)
        }

    }
}