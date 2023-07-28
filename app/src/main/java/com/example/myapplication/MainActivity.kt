package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)

        val moveButton = findViewById<Button>(R.id.btn_a)

        moveButton.setOnClickListener {
            var intent = Intent(this, TwoActivity::class.java)
            startActivity(intent)
        }

    }
}