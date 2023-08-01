package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity25  : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_2)

        var back=findViewById<ImageView>(R.id.back)
        back.setOnClickListener {
            var intent2 = Intent(this, MemoryItem::class.java)
            startActivity(intent2)
        }

    }
}