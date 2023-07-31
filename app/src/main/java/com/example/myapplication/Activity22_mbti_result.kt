package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class Activity22_mbti_result : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mbtir_isfp)

        // 더 알아보러 가기 버튼 -> 나의 여정
        val next = findViewById<AppCompatButton>(R.id.isfpbtn1)

        next.setOnClickListener {
            var intent = Intent(this, Activity26::class.java) //my1으로 이동
            startActivity(intent)
        }

    }
}