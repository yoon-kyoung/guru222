package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class Activity9: AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.join_4)

        val next = findViewById<AppCompatButton>(R.id.finishButton)

        next.setOnClickListener {
            var intent = Intent(this, Activity10::class.java)
            startActivity(intent)
        }

    }
}