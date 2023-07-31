package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity4 : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_onbord3)

        val next = findViewById<TextView>(R.id.Next)

        next.setOnClickListener {
            var intent = Intent(this, Activity5::class.java)
            startActivity(intent)
        }

        val skip = findViewById<TextView>(R.id.textView4)
        skip.setOnClickListener {
            var intent = Intent(this, Activity6_login::class.java)
            startActivity(intent)
        }

    }
}