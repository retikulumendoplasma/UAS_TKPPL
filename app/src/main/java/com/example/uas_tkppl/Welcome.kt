package com.example.uas_tkppl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_welcome.*

class Welcome : AppCompatActivity() {

    var isLakiClicked = false
    var isWanitaClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val lakiClickedLight = resources.getDrawable(R.drawable.laki_pressed_light)
        val lakiUnclickedLight = resources.getDrawable(R.drawable.laki_normal_light)
        val wanitaClickedLight = resources.getDrawable(R.drawable.wanita_pressed_light)
        val wanitaUnclickedLight = resources.getDrawable(R.drawable.wanita_normal_light)



            //start img btn laki
            img_btn_laki.setOnClickListener {
                img_btn_laki.setImageDrawable(lakiClickedLight)
                img_btn_wanita.setImageDrawable((wanitaUnclickedLight))
                isLakiClicked = true
                isWanitaClicked = false
            }//end img btn laki

            //start img btn wanita
            img_btn_wanita.setOnClickListener {
                    img_btn_wanita.setImageDrawable(wanitaClickedLight)
                    img_btn_laki.setImageDrawable((lakiUnclickedLight))
                isWanitaClicked = true
                isLakiClicked = false
            }//end img btn wanita

        img_btn_next.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        }
    }