package com.example.ftest.fragments

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.ftest.R
import com.example.ftest.fragments.easteregg.WaifuActivity
import com.example.ftest.recyclerviews.MessiActivity

class SettingsFragment : Fragment(R.layout.fragment_settings)  {
    private lateinit var defButton: Button
    private lateinit var lightButton: Button
    private lateinit var darkButton: Button
    private lateinit var textView2: TextView




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appSettingPrefs = this.getActivity()?.getSharedPreferences("AppSettingPrefs", 0)

        textView2 = view.findViewById(R.id.textView2)
        val nam = mutableListOf(1)
        textView2.setOnClickListener {


            nam.add(1)
            if (nam.count()>5){
                Toast.makeText(activity,"done", LENGTH_SHORT).show()
                startActivity(Intent(this@SettingsFragment.requireContext(), WaifuActivity::class.java))

                nam.clear()
            }
        }






        defButton = view.findViewById(R.id.defButton)
        lightButton = view.findViewById(R.id.lightButton)
        darkButton = view.findViewById(R.id.darkButton)
        val sharedPrefsEdit: SharedPreferences.Editor? = appSettingPrefs?.edit()
        val isNightModeOn: Int? = appSettingPrefs?.getInt("Mode",0)

        if(isNightModeOn == 3){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
        if(isNightModeOn == 1){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        if(isNightModeOn == 2){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        }


        defButton.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            sharedPrefsEdit?.putInt("Mode", 3)
            sharedPrefsEdit?.apply()

        }

        lightButton.setOnClickListener {

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            sharedPrefsEdit?.putInt("Mode", 1)
            sharedPrefsEdit?.apply()

        }

        darkButton.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

            sharedPrefsEdit?.putInt("Mode", 2)
            sharedPrefsEdit?.apply()

        }


}}