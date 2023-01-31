package com.example.tugas_tkkpl_e_call.helper

import android.content.Context
import android.content.SharedPreferences
import java.nio.channels.spi.AbstractSelectionKey

class preferencesHelper (context:Context) {

    private val PREF_NAME = "SP1"
    private val sharedPref : SharedPreferences
    val editor : SharedPreferences.Editor

    init {
        sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedPref.edit()
    }

    fun put(key: String, value: Boolean){
        editor.putBoolean(key, value).apply()
    }
    fun getBoolean(key: String) : Boolean{
        return sharedPref.getBoolean(key,false)
    }

    fun clear(){
        editor.clear().apply()
    }

}