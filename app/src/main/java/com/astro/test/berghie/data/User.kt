package com.astro.test.berghie.data

import androidx.annotation.DrawableRes

data class User (
    var id : Int = 0,
    var fullName : String,
    var userName : String,
    @DrawableRes val imageResource: Int,
)