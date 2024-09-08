package com.example.parceldeliveryapp.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parceldeliveryapp.data.trackingInformations
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class HomeViewModel: ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _searchTrackingInformations = MutableStateFlow(trackingInformations)
    val searchTrackingInformations = searchText
        .debounce(1000L)
        .onEach { _isSearching.update { true } }
        .combine(_searchTrackingInformations){ text, trackingInfos ->
            if(text.isEmpty()){
                trackingInfos
            }else{
                delay(2000L)
                trackingInfos.filter { it.doesMatchSearchQuery(text) }
            }
        }
        .onEach { _isSearching.update { false } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _searchTrackingInformations.value
        )


    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

}