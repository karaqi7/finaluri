package com.example.ftest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var inputEmail: TextView
    private lateinit var inputPass: TextView
    private lateinit var loginButton: Button
    private lateinit var forgotTv: TextView
    private lateinit var registerTv: TextView
    private lateinit var inputEmailSub: TextView
    private lateinit var inputPassSub: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()

        loginButton.setOnClickListener { login() }
        forgotTv.setOnClickListener{
            startActivity(Intent(this, ForgotPassActivity::class.java))
        }
        registerTv.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))

        }
    }
    private fun init(){

        inputEmail = findViewById(R.id.inputEmail)
        inputPass = findViewById(R.id.inputPass)
        loginButton = findViewById(R.id.loginButton)
        forgotTv = findViewById(R.id.forgotTv)
        registerTv = findViewById(R.id.registerTv)
        inputEmailSub = findViewById(R.id.inputEmailSub)
        inputPassSub = findViewById(R.id.inputPassSub)

    }

    private fun login(){
        val email = inputEmail.text.toString()
        val pass = inputPass.text.toString()
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    Toast.makeText(this,"Error!", Toast.LENGTH_SHORT).show()
                    if (email.isEmpty()){
                        inputEmailSub.text = "email doesnt match"}
                    if (pass.isEmpty()){
                        inputEmailSub.text = "pass doesnt match"}

                }

            }
    }


}