package com.example.ftest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ForgotPassActivity : AppCompatActivity() {

    private lateinit var inputEmail: TextView
    private lateinit var inputEmailSub: TextView
    private lateinit var buttonForgot: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass)

        init()

        iForgor()
    }

    private fun init(){

        inputEmail = findViewById(R.id.inputEmail)
        inputEmailSub = findViewById(R.id.inputEmailSub)
        buttonForgot = findViewById(R.id.buttonForgot)

    }
    private fun iForgor(){

        buttonForgot.setOnClickListener {

            val email = inputEmail.text.toString()

            if ( email.isEmpty()){
                inputEmailSub.text = "Input email"
            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener {
                    task ->
                if (task.isSuccessful){
                    Toast.makeText(this, "Password recovery link Has been sent!", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "User not found!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}