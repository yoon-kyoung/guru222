package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class Activity21 : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mbti12)

        val next = findViewById<AppCompatButton>(R.id.mbtibtn1)
        val two = findViewById<AppCompatButton>(R.id.mbtibtn2)


        next.setOnClickListener {
            var intent = Intent(this, Activity22_mbti_result::class.java)
            startActivity(intent)
        }

        two.setOnClickListener {
            var intent = Intent(this, Activity22_mbti_result::class.java)
            startActivity(intent)
        }
    }
}