package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity2: AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_onbord1)

        val next = findViewById<TextView>(R.id.Next)
        val skip = findViewById<TextView>(R.id.textView4)

        next.setOnClickListener {
            var intent = Intent(this, Activity3::class.java)
            startActivity(intent)
        }

        skip.setOnClickListener {
            var intent = Intent(this, Activity6_login::class.java)
            startActivity(intent)
        }

    }
}