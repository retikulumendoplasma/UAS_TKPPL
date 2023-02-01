package com.example.uas_tkppl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.tugas_tkkpl_e_call.helper.constant
import com.example.tugas_tkkpl_e_call.helper.preferencesHelper

class Recomendation : AppCompatActivity() {
    lateinit var sharedPref: preferencesHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recomendation)


        sharedPref = preferencesHelper(this)

        if (sharedPref.getBoolean(constant.PREF_ISON) == true) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }


    }
}