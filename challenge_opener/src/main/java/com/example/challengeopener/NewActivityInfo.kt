package com.example.challengeopener

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class NewActivityInfo(
    @StringRes val activityTitle: Int,
    @StringRes val activityDescription: Int,
    @DrawableRes val activityIcon: Int
)
