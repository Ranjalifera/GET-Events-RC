package com.example.myapplication.model

import android.content.res.Resources
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Event(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val stringResources: Int,
//    var date: String = "",
//    var heure: String = "",
//    var lieu: String = "",
)
