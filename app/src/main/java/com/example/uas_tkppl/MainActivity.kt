package com.example.uas_tkppl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.tugas_tkkpl_e_call.helper.constant
import com.example.tugas_tkkpl_e_call.helper.preferencesHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var sharedPref: preferencesHelper

    override fun onStart() {
        super.onStart()
        if (sharedPref.getBoolean(constant.PREF_ISON) == true){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPref = preferencesHelper(this)

        tv_usiaWelcome.setText(sharedPref.getString(constant.PREF_AGE))
        tv_jenisKelaminWelcome.setText(sharedPref.getString(constant.PREF_GENDER))

        fun CountResultBMI() {
            val berat = et_berat_badan.text.toString().toInt()
            val tinggi = et_tinggi_badan.text.toString().toInt()
            val intent = Intent(this, Result::class.java)
            intent.putExtra("berat", berat)
            intent.putExtra("tinggi",tinggi)
            startActivity(intent)
        }

        img_btn_calculate.setOnClickListener {
            if (et_berat_badan.text.toString() == "" || et_tinggi_badan.text.toString() == ""){
                Toast.makeText(this, "berat / tinggi badan tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            }
            else{
                CountResultBMI()
            }
        }





        //title action bar
        setTitle("BMI CALCULATOR")



    }

    //setting_untuk_dark_dan_light_mode
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu, menu)

        return true
    }

    // option item for a change mode -->
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {


            R.id.Light_mode -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedPref.putBoolean(constant.PREF_ISON,false)
            }

            R.id.Dark_mode -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedPref.putBoolean(constant.PREF_ISON,true)
            }

            R.id.reset -> {
                sharedPref.putString(constant.PREF_GENDER, "")
                sharedPref.putString(constant.PREF_AGE, "0")
                sharedPref.putBoolean(constant.PREF_ISLOGIN, false)
                val intent = Intent(this, Welcome::class.java)
                finish()
                startActivity(intent)

            }

        }
        return super.onOptionsItemSelected(item)
    }
}