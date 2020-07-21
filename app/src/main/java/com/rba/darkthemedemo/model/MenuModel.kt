package com.rba.darkthemedemo.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MenuModel(@DrawableRes val icon: Int, val description: String) : Parcelable