package com.example.parceldeliveryapp.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.MailOutline
import com.example.parceldeliveryapp.R
import com.example.parceldeliveryapp.presentation.bottom_nav.BottomNavItem
import com.example.parceldeliveryapp.presentation.home.model.TrackingInformation
import com.example.parceldeliveryapp.presentation.home.model.Vehicle
import com.example.parceldeliveryapp.presentation.shipment.model.Shipment
import com.example.parceldeliveryapp.presentation.shipment.model.ShipmentStatus
import com.example.parceldeliveryapp.presentation.shipment.model.TabItem


val bottomNavItems = listOf(
    BottomNavItem("Home", "home", Icons.Outlined.Home, Icons.Filled.Home),
    BottomNavItem("Calculate", "calculate", Icons.Outlined.DateRange, Icons.Filled.DateRange),
    BottomNavItem("Shipments", "shipments", Icons.Outlined.MailOutline, Icons.Filled.Email),
)


val tabItems = mutableListOf<TabItem>().apply{
    ShipmentStatus.entries.forEach {
        add(
            TabItem(it.title, Icons.Outlined.Info, Icons.Filled.Info)
        )
    }
}


val categories = listOf("Box", "Documents", "Glass", "Liquid", "Food", "Electronic", "Product", "Others")

val trackingInformations = listOf(
    TrackingInformation(
        packageName = "Macbook Pro",
        trackingNumber = "NEJ20089934122231",
        senderLocation = "Atlanta, 5243",
        recieverLocation = "Chicago 6342",
        time = "2 day - 3 days",
        status = "Waiting to Collect"
    ),
    TrackingInformation(
        packageName = "Linen Jacket",
        trackingNumber = "NEJ20089934122231",
        senderLocation = "Chicago 6342",
        recieverLocation = "Atlanta 5243",
        time = "5 day - 10 days",
        status = "Waiting to Collect"
    ),
    TrackingInformation(
        packageName = "Power Bike",
        trackingNumber = "NEJ20089934122231",
        senderLocation = "Paris, 4483",
        recieverLocation = "Bacerlona 2271",
        time = "4 day - 6 days",
        status = "Waiting to Collect"
    ),
    TrackingInformation(
        packageName = "Nike SB",
        trackingNumber = "NEJ20089934122231",
        senderLocation = "Germany 7429",
        recieverLocation = "France 4483",
        time = "3 day - 8 days",
        status = "Waiting to Collect"
    ),
)


val vehicleList = listOf(
    Vehicle(
        name = "Ocean freight",
        vehicleReach = "International",
        image = R.drawable.ocean_freight,
    ),
    Vehicle(
        name = "Cargo freight",
        vehicleReach = "Reliable",
        image = R.drawable.cargo_freight,
    ),
    Vehicle(
        name = "Air freight",
        vehicleReach = "International",
        image = R.drawable.air_freight,
    ),
)

val shipmentStatus = listOf(
    ShipmentStatus.ALL,
    ShipmentStatus.COMPLETED,
    ShipmentStatus.IN_PROGRESS,
    ShipmentStatus.PENDING,
    ShipmentStatus.LOADING,
    ShipmentStatus.CANCELLED
)

val shipments = listOf(
    Shipment(
        deliveryName = "NEJ20089934122231",
        senderLocation = "Atlanta",
        deliveryTime = "Sep 2, 2024",
        deliveryStatus = ShipmentStatus.IN_PROGRESS,
        arrivalDay = "Arriving today",
        amount = "$1400 USD",
        image = 0,
    ),
    Shipment(
        deliveryName = "NEJ20089934122231",
        senderLocation = "Atlanta",
        deliveryTime = "Sep 2, 2024",
        deliveryStatus = ShipmentStatus.PENDING,
        arrivalDay = "Arriving today",
        amount = "$1400 USD",
        image = 0,
    ),
    Shipment(
        deliveryName = "NEJ20089934122231",
        senderLocation = "Atlanta",
        deliveryTime = "Sep 2, 2024",
        deliveryStatus = ShipmentStatus.LOADING,
        arrivalDay = "Arriving today",
        amount = "$1400 USD",
        image = 0,
    ),
    Shipment(
        deliveryName = "NEJ20089934122231",
        senderLocation = "Atlanta",
        deliveryTime = "Sep 2, 2024",
        deliveryStatus = ShipmentStatus.COMPLETED,
        arrivalDay = "Arriving today",
        amount = "$1400 USD",
        image = 0,
    ),
    Shipment(
        deliveryName = "NEJ20089934122231",
        senderLocation = "Atlanta",
        deliveryTime = "Sep 2, 2024",
        deliveryStatus = ShipmentStatus.CANCELLED,
        arrivalDay = "Arriving today",
        amount = "$1400 USD",
        image = 0,
    ),
)