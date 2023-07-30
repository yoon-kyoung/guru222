package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class Activity8 : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.join_3)

        val next = findViewById<AppCompatButton>(R.id.nextButton)

        next.setOnClickListener {
            var intent = Intent(this, Activity9::class.java)
            startActivity(intent)
        }

    }
}