package com.example.ftest.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.ftest.R

class SettingsFragment : Fragment(R.layout.fragment_settings)  {
    private lateinit var defButton: Button
    private lateinit var lightButton: Button
    private lateinit var darkButton: Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appSettingPrefs = this.getActivity()?.getSharedPreferences("AppSettingPrefs", 0)


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

    }
}