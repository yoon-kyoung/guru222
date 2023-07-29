package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import com.example.myapplication.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //인증 초기화
        var myAuth = Firebase.auth

        //로그인 버튼 이벤트
        binding.loginBtn.setOnClickListener{
            val email = binding.emailEdit.text.toString()
            val password = binding.passwordEdit.text.toString()

            login(email, password)
        }

        fun Intent(loginActivity: LoginActivity) {

        }

        //로그인
        fun login(email:String, password:String){
    mAuth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener(this){task ->
            if(task.isSuccessful){
                val intent: Intent =Intent(this@LoginActivity,
                MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                //실패시
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
                Log.d("Login", "Error: $(task.exception}")
        }
            }
            }
        }

    private fun login(email: String, password: String) {

    }
}

