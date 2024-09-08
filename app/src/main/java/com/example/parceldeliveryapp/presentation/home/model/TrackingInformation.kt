package com.example.parceldeliveryapp.presentation.home.model

import com.example.parceldeliveryapp.data.interface_usecase.ISearchable
import kotlinx.serialization.Serializable

@Serializable
data class TrackingInformation(
    val packageName: String,
    val trackingNumber: String,
    val senderLocation: String,
    val recieverLocation: String,
    val time: String,
    var status: String
) : ISearchable {

    override fun doesMatchSearchQuery(query: String): Boolean{
        val matchingCombination = listOf(
            "$trackingNumber $packageName",
            "$trackingNumber$packageName",
            "${trackingNumber.first()} ${packageName.first()}",
            "$trackingNumber$packageName$recieverLocation$senderLocation",
            "$trackingNumber $packageName $recieverLocation $senderLocation",
            "${trackingNumber.first()} ${packageName.first()} ${recieverLocation.first()} ${senderLocation.first()}",
        )
        return matchingCombination.any{
            it.contains(query, ignoreCase = true)
        }
    }
}