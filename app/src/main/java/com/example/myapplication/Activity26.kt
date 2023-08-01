package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity26  : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_start)

        var la =findViewById<TextView>(R.id.txtOne)
        la.setOnClickListener {
            var intent2 = Intent(this, Activity27::class.java)
            startActivity(intent2)
        }

    }
}