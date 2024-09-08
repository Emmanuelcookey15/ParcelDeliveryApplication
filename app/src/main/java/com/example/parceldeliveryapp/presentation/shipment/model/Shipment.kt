package com.example.parceldeliveryapp.presentation.shipment.model

import androidx.annotation.DrawableRes

data class Shipment(
    val deliveryName: String,
    val senderLocation: String,
    val deliveryTime: String,
    var deliveryStatus: ShipmentStatus,
    val arrivalDay: String,
    val amount: String,
    @DrawableRes val image: Int,
)
