package com.example.uas_tkppl

import android.app.UiModeManager.MODE_NIGHT_NO
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.tugas_tkkpl_e_call.helper.constant
import com.example.tugas_tkkpl_e_call.helper.preferencesHelper
import kotlinx.android.synthetic.main.activity_welcome.*

class Welcome : AppCompatActivity() {
    lateinit var sharedPref: preferencesHelper


    var isLakiClicked = false
    var isWanitaClicked = false

    override fun onStart() {
        super.onStart()
        et_usia.setText("0")
        if (sharedPref.getBoolean(constant.PREF_ISLOGIN) == true){
            val intent = Intent(this, MainActivity::class.java)
            finish()
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)




        //light
        val lakiClickedLight = resources.getDrawable(R.drawable.laki_pressed_light)
        val lakiUnclickedLight = resources.getDrawable(R.drawable.laki_normal_light)
        val wanitaClickedLight = resources.getDrawable(R.drawable.wanita_pressed_light)
        val wanitaUnclickedLight = resources.getDrawable(R.drawable.wanita_normal_light)
        //dark
        val lakiClickedDark = resources.getDrawable(R.drawable.laki_pressed_dark)
        val lakiUnclickedDark = resources.getDrawable(R.drawable.laki_black_dark)
        val wanitaClickedDark = resources.getDrawable(R.drawable.wanita_pressed_dark)
        val wanitaUnclickedDark = resources.getDrawable(R.drawable.wanita_black_dark)

        sharedPref = preferencesHelper(this)
        sharedPref.putString(constant.PREF_GENDER, "")

        if (sharedPref.getBoolean(constant.PREF_ISON) == true){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

            img_btn_laki.setOnClickListener {

                img_btn_laki.setImageDrawable(lakiClickedDark)
                img_btn_wanita.setImageDrawable(wanitaUnclickedDark)
                sharedPref.putString(constant.PREF_GENDER,"Laki - laki")
                isLakiClicked = true
                isWanitaClicked = false
            }

            img_btn_wanita.setOnClickListener {
                img_btn_wanita.setImageDrawable(wanitaClickedDark)
                img_btn_laki.setImageDrawable(lakiUnclickedDark)
                sharedPref.putString(constant.PREF_GENDER,"Wanita")
                isWanitaClicked = true
                isLakiClicked = false
            }
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            img_btn_laki.setOnClickListener {
                img_btn_laki.setImageDrawable(lakiClickedLight)
                img_btn_wanita.setImageDrawable(wanitaUnclickedLight)
                sharedPref.putString(constant.PREF_GENDER,"Laki - laki")
                isLakiClicked = true
                isWanitaClicked = false
            }

            img_btn_wanita.setOnClickListener {
                img_btn_wanita.setImageDrawable(wanitaClickedLight)
                img_btn_laki.setImageDrawable(lakiUnclickedLight)
                sharedPref.putString(constant.PREF_GENDER,"Wanita")
                isWanitaClicked = true
                isLakiClicked = false
            }
        }



        var umur = 0
        umur = et_usia.text.toString().toInt()

        img_btn_plus.setOnClickListener {
            if (umur < 110){
                umur = et_usia.text.toString().toInt()
                umur += 1
                et_usia.setText(umur.toString())
                sharedPref.putString(constant.PREF_AGE,umur.toString())
            }
        }

        img_btn_min.setOnClickListener {
            if (umur > 1) {
                umur = et_usia.text.toString().toInt()
                umur -= 1
                et_usia.setText(umur.toString())
                sharedPref.putString(constant.PREF_AGE,umur.toString())
            }
        }



        img_btn_next.setOnClickListener {

            sharedPref.putString(constant.PREF_AGE,et_usia.text.toString())

            if(sharedPref.getString(constant.PREF_GENDER)=="" || sharedPref.getString(constant.PREF_AGE)=="0"){
                Toast.makeText(this, "Jenis kelamin atau Umur belum diisi", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, MainActivity::class.java)
                sharedPref.putBoolean(constant.PREF_ISLOGIN,true)

                finish()
                startActivity(intent)
            }

        }

        }
    }