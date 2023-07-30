package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class Activity6 : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.join_1)

        val next = findViewById<AppCompatButton>(R.id.nextButton)

        next.setOnClickListener {
            var intent = Intent(this, Activity7::class.java)
            startActivity(intent)
        }

    }
}