package com.example.ftest.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.ftest.R
import com.example.ftest.UserInfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private val user = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance().getReference("UserInfo")
    private lateinit var imageView: ImageView
    private lateinit var usernameTextView: TextView
    private lateinit var changePassTextView: TextView
    private lateinit var logoutText: TextView
    private lateinit var changeUsernameButton: Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageView = view.findViewById(R.id.imageView)
        usernameTextView = view.findViewById(R.id.usernameTextView)
        changePassTextView = view.findViewById(R.id.changePassTextView)
        logoutText = view.findViewById(R.id.logoutText)
        changeUsernameButton = view.findViewById(R.id.changeUsernameButton)
        usernameTextView.text = user.currentUser?.uid!!

        db.child(user.currentUser?.uid!!).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val userInfo = snapshot.getValue(UserInfo::class.java) ?: return
                usernameTextView.text = userInfo.name
                val img = userInfo.url

                Glide.with(this@ProfileFragment)
                    .load(img)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(imageView)

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        changeUsernameButton.setOnClickListener {
            val dialog = ChangeUsernameFragment()
            dialog.show(childFragmentManager, "custom")


        }




}}