package com.example.ftest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var inputEmail: TextView
    private lateinit var inputPass: TextView
    private lateinit var registerButton: Button
    private lateinit var alreadyTv: TextView
    private lateinit var inputPass2: TextView
    private lateinit var inputEmailSub: TextView
    private lateinit var inputPassSub: TextView
    private lateinit var inputPassSub2: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        init()


        alreadyTv.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }
        registerButton.setOnClickListener {
            register()
        }

    }

    private fun init(){

        inputEmail = findViewById(R.id.inputEmail)
        inputPass = findViewById(R.id.inputPass)
        registerButton = findViewById(R.id.registerButton)
        alreadyTv = findViewById(R.id.alreadyTv)
        inputPass2 = findViewById(R.id.inputPass2)
        inputEmailSub = findViewById(R.id.inputEmailSub)
        inputPassSub = findViewById(R.id.inputPassSub)
        inputPassSub2 = findViewById(R.id.inputPassSub2)

    }

    private fun register(){

        val email = inputEmail.text.toString()
        val pass = inputPass.text.toString()
        val pass2 = inputPass2.text.toString()

        if (email.isEmpty()) {
            inputEmailSub.text = "Email is Required"
        }else{
            inputEmailSub.text = ""
        }
        if (pass.isEmpty()) {
            inputPassSub.text = "Password is Required"
        }else{
            inputPassSub.text = ""
        }
        if (pass2.isEmpty()) {
            inputPassSub2.text = "Password is Required"
        }
        else{
            inputPassSub2.text = ""
        }

        if (pass == pass2 && pass.length > 9 && pass.contains("[0-9]".toRegex()) && pass.contains("[a-z]".toRegex()) && email.contains("@") ){
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
                if (pass != pass2){
                    inputPassSub2.text = "passwords dont match"

                }else
                {
                    inputPassSub.text = "pass must be 9 char or longer and it requires numbers"
                }
            }}

    }
}