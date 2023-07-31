package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class Activity6 : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val next = findViewById<AppCompatButton>(R.id.loginBtn)
        val join = findViewById<TextView>(R.id.textView4)

        next.setOnClickListener {
            var intent = Intent(this, Activity23_my::class.java)
            startActivity(intent)
        }

        join.setOnClickListener {
            var intent = Intent(this, Activity7::class.java)
            startActivity(intent)
        }


    }
}