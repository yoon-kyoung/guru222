package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import android.util.Log
import com.example.myapplication.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignUpBinding
    lateinit var mAuth: FirebaseAuth

    private lateinit var mDbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 인증 초기화
        mAuth = Firebase.auth

        // db 초기화
        mDbRef = Firebase.database.reference

        binding.signupBtn.setOnClickListener {
            val email = binding.emailEdit.text.toString().trim()
            val password = binding.passwordEdit.text.toString().trim()

            Log.d("signup", email)
            Log.d("signup", password)
            signUp(email, password)
        }
    }

    private fun addUSerToDatabase(email: String, uid: String) {
        // 사용자 정보를 저장할 노드 경로
        val usersRef = mDbRef.child("users")

        // 사용자 정보를 해시맵으로 생성합니다.
        val userMap = HashMap<String, Any>()
        userMap["email"] = email
        userMap["uid"] = uid

        // 파이어베이스 데이터베이스에 사용자 정보를 저장
        usersRef.child(uid).setValue(userMap)
            .addOnSuccessListener {
                // 저장 성공시
                Log.d("SignUp", "사용자 정보 저장 성공")
            }
            .addOnFailureListener { exception ->
                // 저장 실패시
                Log.e("SignUp", "사용자 정보 저장 실패", exception)
            }
    }


    // 회원가입
    private fun signUp(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // 성공시
                    Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
                    val intent: Intent = Intent(this@SignUpActivity, MainActivity::class.java)
                    startActivity(intent)
                    addUSerToDatabase(email, mAuth.currentUser?.uid!!)

                } else {
                    // 실패시
                    Toast.makeText(this, "회원가입 실패", Toast.LENGTH_SHORT).show()
                    Log.d("SignUp", "Error: ${task.exception}")
                }
            }
    }
}




