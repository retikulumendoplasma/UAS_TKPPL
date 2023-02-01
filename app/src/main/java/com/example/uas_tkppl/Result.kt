package com.example.uas_tkppl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.tugas_tkkpl_e_call.helper.constant
import com.example.tugas_tkkpl_e_call.helper.preferencesHelper
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {

    lateinit var sharedPref: preferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val gemuk = "Nilai indeks massa tubuh (IMT) di atas 25.0 Anda dianggap memiliki kelebihan berat badan"
        val normal= "Nilai indeks massa tubuh Anda 18.5 sampai 24.9, artinya Anda memiliki berat badan normal"
        val kurus = "Nilai indeks massa tubuh (IMT) di bawah 18,5 menandakan berat badan Anda kurang"

        sharedPref = preferencesHelper(this)

        if (sharedPref.getBoolean(constant.PREF_ISON) == true) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }

            val berat = intent.getIntExtra("berat", 0)
            val tinggi = intent.getIntExtra("tinggi", 0)

            val hasilBMI = berat.toFloat() / (tinggi.toFloat() * tinggi.toFloat() / 10000)

            val format1decimal = "%.1f".format(hasilBMI)
            tv_score_bmi.setText(format1decimal)


            img_btn_back.setOnClickListener {
                finish()
            }


    }

}
