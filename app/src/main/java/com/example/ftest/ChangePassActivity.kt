package com.example.ftest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ChangePassActivity : AppCompatActivity() {
    private lateinit var newPassword: TextView
    private lateinit var newPassButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_pass)

        init()

        registerListeners()

    }

    private fun init(){
        newPassword = findViewById(R.id.newPassword)
        newPassButton = findViewById(R.id.newPassButton)
    }
    private fun registerListeners() {
        newPassButton.setOnClickListener {
            val newpass = newPassword.text.toString()

            if (newpass.isEmpty() || newpass.length < 9) {
                Toast.makeText(this, "Incorrect new password!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().currentUser?.updatePassword(newpass)
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
                    } else
                        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                }
        }
    }
}