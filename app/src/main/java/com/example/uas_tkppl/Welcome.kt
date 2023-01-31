package com.example.uas_tkppl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.tugas_tkkpl_e_call.helper.constant
import com.example.tugas_tkkpl_e_call.helper.preferencesHelper
import kotlinx.android.synthetic.main.activity_welcome.*

class Welcome : AppCompatActivity() {
    lateinit var sharedPref: preferencesHelper


    var isLakiClicked = false
    var isWanitaClicked = false
    var age = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val lakiClickedLight = resources.getDrawable(R.drawable.laki_pressed_light)
        val lakiUnclickedLight = resources.getDrawable(R.drawable.laki_normal_light)
        val wanitaClickedLight = resources.getDrawable(R.drawable.wanita_pressed_light)
        val wanitaUnclickedLight = resources.getDrawable(R.drawable.wanita_normal_light)

        sharedPref = preferencesHelper(this)

        if (sharedPref.getBoolean(constant.PREF_ISON) == true){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }

            //button gender
            img_btn_laki.setOnClickListener {
                img_btn_laki.setImageDrawable(lakiClickedLight)
                img_btn_wanita.setImageDrawable(wanitaUnclickedLight)
                isLakiClicked = true
                isWanitaClicked = false
            }

            img_btn_wanita.setOnClickListener {
                    img_btn_wanita.setImageDrawable(wanitaClickedLight)
                    img_btn_laki.setImageDrawable(lakiUnclickedLight)
                isWanitaClicked = true
                isLakiClicked = false
            }


        var umur = et_usia.text.toString().toInt()

        img_btn_plus.setOnClickListener {
            if (umur < 110){
                umur = et_usia.text.toString().toInt()
                umur += 1
                et_usia.setText(umur.toString())
            }
        }

        img_btn_min.setOnClickListener {
            if (umur > 1) {
                umur = et_usia.text.toString().toInt()
                umur -= 1
                et_usia.setText(umur.toString())
            }
        }

        age = umur


        img_btn_next.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        }
    }