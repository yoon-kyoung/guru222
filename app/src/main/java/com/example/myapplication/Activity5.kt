package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity5 : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_onbord4)

        val next = findViewById<TextView>(R.id.Next)

        next.setOnClickListener {
            var intent = Intent(this, Activity6_login::class.java)
            startActivity(intent)
        }


    }
}