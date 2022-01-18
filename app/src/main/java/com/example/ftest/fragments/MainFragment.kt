package com.example.ftest.fragments


import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.ftest.R

class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var imageMessi : ImageView
    private lateinit var imageRonaldo : ImageView
    private lateinit var imageNeymar : ImageView
    private lateinit var imageMbappe : ImageView
    private lateinit var imageLewandowski : ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageMessi = view.findViewById(R.id.imageMessi)
        imageRonaldo = view.findViewById(R.id.imageRonaldo)
        imageNeymar = view.findViewById(R.id.imageNeymar)
        imageMbappe = view.findViewById(R.id.imageMbappe)
        imageLewandowski = view.findViewById(R.id.imageLewandowski)

        registerListeners()
    }


    private fun registerListeners() {

        // RecyclerView -ს სანამ არ გავაკეთებთ, ეს ფუნცია ასე იყოს დროებით

        imageMessi.setOnClickListener {
            //მგონი ინტენტი არ მუშაობსს
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