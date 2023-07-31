package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

private const val SPLASH_DELAY: Long = 3000 // 스플래시 화면 표시 시간 (3초)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)

        val moveButton = findViewById<Button>(R.id.btn_a)

        moveButton.setOnClickListener {
            var intent = Intent(this, Activity2::class.java)
            startActivity(intent)
        }

    }
}