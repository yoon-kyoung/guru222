package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class Activity23_my : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my1)

        // 추천 여행지 보러가기
        val next = findViewById<AppCompatButton>(R.id.mybtn1)
        val memoey = findViewById<Button>(R.id.mybtn2)

        next.setOnClickListener {
            var intent = Intent(this, Activity24_searching::class.java) //searching으로 이동
            startActivity(intent)
        }

        memoey.setOnClickListener {
            var intent = Intent(this, Activity26::class.java)
            startActivity(intent)
        }


    }
}