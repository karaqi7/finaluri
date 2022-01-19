package com.example.ftest

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var inputEmail: TextView
    private lateinit var inputPass: TextView
    private lateinit var loginButton: Button
    private lateinit var forgotTv: TextView
    private lateinit var registerTv: TextView
    private lateinit var inputEmailSub: TextView
    private lateinit var inputPassSub: TextView
    private lateinit var cb: CheckBox
    var isRemebered = false
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()


        forgotTv.setOnClickListener{
            startActivity(Intent(this, ForgotPassActivity::class.java))
        }
        registerTv.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))

        }

        sharedPreferences = getSharedPreferences("SHARED_PREF2", Context.MODE_PRIVATE)
        isRemebered = sharedPreferences.getBoolean("CB", false)

        if(isRemebered){
            inputEmail.text = sharedPreferences.getString("EMAIL", "")
            inputPass.text = sharedPreferences.getString("PASS", "")


            val email = inputEmail.text.toString()
            val pass = inputPass.text.toString()
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener { task ->

                    if (task.isSuccessful){
                        startActivity(Intent(this, MainActivity::class.java))
                    } else {
                        Toast.makeText(this, "Account Not Found", Toast.LENGTH_SHORT).show()


                    }}


        }

        loginButton.setOnClickListener {

            login()
            if (inputEmail.text.isEmpty()){

                inputEmailSub.text = "Please Input Email"

            }

            if (inputPass.text.isEmpty()){

                inputPassSub.text = "Please Input Password"

            }
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
        cb = findViewById(R.id.cb)

    }

    private fun login(){
        val email = inputEmail.text.toString()
        val pass = inputPass.text.toString()
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener { task ->

                if (task.isSuccessful && cb.isChecked){
                    val checked: Boolean = cb.isChecked

                    val editor: SharedPreferences.Editor = sharedPreferences.edit()
                    editor.putString("EMAIL", email)
                    editor.putString("PASS", pass)
                    editor.putBoolean("CB", checked)
                    editor.apply()

                    finish()



                }

                if (task.isSuccessful){
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this,"Account Not Found", Toast.LENGTH_SHORT).show()


                }

            }
    }


}