package com.example.challengeopener

import androidx.annotation.DrawableRes

data class NewActivityInfo(
    val activityTitle: String,
    val activityDescription: String,
    @DrawableRes val activityIcon: Int
)
