package com.rba.darkthemedemo.base

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.rba.darkthemedemo.util.SharedPreferencesUtil

abstract class BaseFragment : Fragment() {

    abstract fun layout(): Int
    lateinit var sharedPreferencesUtil: SharedPreferencesUtil

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharedPreferencesUtil = SharedPreferencesUtil(context?.applicationContext!!)
        changeTheme()
        return inflater.inflate(layout(), container, false)
    }

    fun changeTheme() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            if (sharedPreferencesUtil.getDarkTheme()) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

}