package com.example.uas_tkppl

import android.graphics.Color
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

        var jikaKurusNormalGemuk = ""

        sharedPref = preferencesHelper(this)

        if (sharedPref.getBoolean(constant.PREF_ISON) == true) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }

        val berat = intent.getIntExtra("berat", 0)
        val tinggi = intent.getIntExtra("tinggi", 0)

        val hasilBMI = berat.toFloat() / (tinggi.toFloat() * tinggi.toFloat() / 10000)

        if (hasilBMI < 18.5){
            jikaKurusNormalGemuk = "kurus"
            intent.putExtra("jikakurus",jikaKurusNormalGemuk)
            tv_hasil_besar.setText("KURUS")
            tv_hasil_besar.setTextColor(Color.BLUE)
            tv_hasil_rincian.setText(kurus)
        }
        else if (hasilBMI >= 18.5 && hasilBMI <=24.9){
            jikaKurusNormalGemuk = "normal"
            intent.putExtra("jikakurus",jikaKurusNormalGemuk)
            tv_hasil_besar.setText("NORMAL")
            tv_hasil_besar.setTextColor(Color.GREEN)
            tv_hasil_rincian.setText(normal)
        }
        else{
            jikaKurusNormalGemuk = "gemuk"
            intent.putExtra("jikakurus",jikaKurusNormalGemuk)
            tv_hasil_besar.setText("GEMUK")
            tv_hasil_besar.setTextColor(Color.RED)
            tv_hasil_rincian.setText(gemuk)

        }

        val format1decimal = "%.1f".format(hasilBMI)
        tv_score_bmi.setText(format1decimal)


        img_btn_back.setOnClickListener {
            finish()
        }


    }

}
