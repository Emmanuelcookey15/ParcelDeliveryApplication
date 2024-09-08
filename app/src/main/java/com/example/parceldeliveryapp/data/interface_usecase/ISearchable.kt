package com.example.parceldeliveryapp.data.interface_usecase

interface ISearchable{

    fun doesMatchSearchQuery(query: String): Boolean
}