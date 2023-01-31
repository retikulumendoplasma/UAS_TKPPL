package com.example.uas_tkppl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatDelegate
import com.example.tugas_tkkpl_e_call.helper.constant
import com.example.tugas_tkkpl_e_call.helper.preferencesHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_welcome.*

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
                sharedPref.clear()
            }

            R.id.Dark_mode -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedPref.put(constant.PREF_ISON,true)
            }

        }
        return super.onOptionsItemSelected(item)
    }
}