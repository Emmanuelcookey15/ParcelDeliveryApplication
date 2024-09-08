package com.example.parceldeliveryapp.presentation.shipment.model

enum class ShipmentStatus(val title: String) {
    ALL("All"),
    COMPLETED("Completed"),
    IN_PROGRESS("In progress"),
    PENDING("Pending"),
    LOADING("Loading"),
    CANCELLED("Cancelled"),
}