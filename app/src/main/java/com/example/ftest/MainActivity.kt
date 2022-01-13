package com.example.ftest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var imageMessi : ImageView
    private lateinit var imageRonaldo : ImageView
    private lateinit var imageNeymar : ImageView
    private lateinit var imageMbappe : ImageView
    private lateinit var imageLewandowski : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        registerListeners()
    }

    private fun init() {
        imageMessi = findViewById(R.id.imageMessi)
        imageRonaldo = findViewById(R.id.imageRonaldo)
        imageNeymar = findViewById(R.id.imageNeymar)
        imageMbappe = findViewById(R.id.imageMbappe)
        imageLewandowski = findViewById(R.id.imageLewandowski)
    }

    private fun registerListeners() {

        // RecyclerView -ს სანამ არ გავაკეთებთ, ეს ფუნცია ასე იყოს დროებით

        imageMessi.setOnClickListener {

        }
        imageRonaldo.setOnClickListener {

        }
        imageNeymar.setOnClickListener {

        }
        imageMbappe.setOnClickListener {

        }
        imageLewandowski.setOnClickListener {

        }
    }


}