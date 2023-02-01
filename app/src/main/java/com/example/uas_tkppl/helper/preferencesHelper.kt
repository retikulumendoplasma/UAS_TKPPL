package com.example.tugas_tkkpl_e_call.helper

import android.content.Context
import android.content.SharedPreferences

class preferencesHelper (context:Context) {

    private val PREF_NAME = "SP1"
    private val sharedPref : SharedPreferences
    val editor : SharedPreferences.Editor

    init {
        sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedPref.edit()
    }

    fun putBoolean(key: String, value: Boolean){
        editor.putBoolean(key, value).apply()
    }
    fun getBoolean(key: String) : Boolean{
        return sharedPref.getBoolean(key,false)
    }

    fun putString(key: String, value: String){
        editor.putString(key, value).apply()
    }

    fun getString(key: String) : String?{
        return sharedPref.getString(key,null)
    }

    fun clear(){
        editor.clear().apply()
    }

}