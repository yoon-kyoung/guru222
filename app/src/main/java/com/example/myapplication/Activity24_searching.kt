package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Activity24_searching : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.searching111)

        val my = findViewById<ImageView>(R.id.myicon)
        val lav = findViewById<ImageView>(R.id.imageView18)

        my.setOnClickListener {
            var intent2 = Intent(this, MemoryItem::class.java)
            startActivity(intent2)
        }
        lav.setOnClickListener {
            var intent2 = Intent(this, Activity25::class.java)
            startActivity(intent2)
        }
        val searchbox = findViewById<ImageView>(R.id.imageView33)

        searchbox.setOnClickListener {
            var intent2 = Intent(this, Activity26::class.java)
            startActivity(intent2)
        }



    }
}