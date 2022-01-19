package com.example.ftest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.ftest.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserInfo
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ChangeUsernameFragment : DialogFragment() {
    private val user = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance().getReference("UserInfo")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView: View = inflater.inflate(R.layout.fragment_change_username, container, false)
        val cancelButton = rootView.findViewById<Button>(R.id.cancelButton)
        val saveButton = rootView.findViewById<Button>(R.id.saveButton)
        val editTextName = rootView.findViewById<EditText>(R.id.editTextName)
        val editTextUrle = rootView.findViewById<EditText>(R.id.editTextUrle)



        cancelButton.setOnClickListener {
            dismiss()
        }

        saveButton.setOnClickListener {
            val name = editTextName.text.toString()
            val url = editTextUrle.text.toString()

            if (url.isNotEmpty()){
                val userInfo = com.example.ftest.UserInfo(url, name)
                db.child(user.currentUser?.uid!!).setValue(userInfo)
            }

            if (name.isNotEmpty()){
                val userInfo = com.example.ftest.UserInfo(url, name)
                db.child(user.currentUser?.uid!!).setValue(userInfo)
            }
            if (url.isNotEmpty() && name.isNotEmpty()){
                val userInfo = com.example.ftest.UserInfo(url, name)

                db.child(user.currentUser?.uid!!).setValue(userInfo)
            }

            db.child(user.currentUser?.uid!!).addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val userInfo = snapshot.getValue(com.example.ftest.UserInfo::class.java) ?: return
                    val nameBase = userInfo.name
                    val urlBase = userInfo.url

                    val name = editTextName.text.toString()
                    val url = editTextUrle.text.toString()

                    if (url.isNotEmpty()){
                        val userInfo = com.example.ftest.UserInfo(url, nameBase)
                        db.child(user.currentUser?.uid!!).setValue(userInfo)
                    }

                    if (name.isNotEmpty()){
                        val userInfo = com.example.ftest.UserInfo(urlBase, name)
                        db.child(user.currentUser?.uid!!).setValue(userInfo)
                    }
                    if (url.isNotEmpty() && name.isNotEmpty()){
                        val userInfo = com.example.ftest.UserInfo(url, name)

                        db.child(user.currentUser?.uid!!).setValue(userInfo)
                    }

                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })


            dismiss()
        }
        return rootView
    }
}