package com.example.parceldeliveryapp.presentation.home.model

import androidx.annotation.DrawableRes

data class Vehicle(
    val name: String,
    val vehicleReach: String,
    @DrawableRes val image: Int,

)
