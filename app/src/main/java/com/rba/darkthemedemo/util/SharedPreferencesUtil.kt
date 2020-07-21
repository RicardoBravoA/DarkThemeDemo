package com.rba.darkthemedemo.util

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesUtil(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE)

    fun saveDarkTheme(value: Boolean) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean(DARK_THEME, value)
        editor.apply()
    }

    fun getDarkTheme(): Boolean {
        return sharedPreferences.getBoolean(DARK_THEME, false)
    }

    companion object {
        const val NAME = "DARK-THEME"
        const val DARK_THEME = "DARK-THEME"
    }

}