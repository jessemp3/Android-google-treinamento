package com.jesse.grade_exe.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceId: Int,
    val quantity: Int,
    @DrawableRes val imageResourceId: Int
)
