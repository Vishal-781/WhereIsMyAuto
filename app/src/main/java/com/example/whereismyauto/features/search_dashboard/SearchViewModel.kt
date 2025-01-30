package com.example.whereismyauto.features.search_dashboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SearchViewModel: ViewModel() {
    var startingPoint: String by mutableStateOf("")
        private set

    var destinationPoint: String by mutableStateOf("")
        private set

    var searchAutoName: String by mutableStateOf("")
        private set

    var activeRides : List<String> by mutableStateOf(listOf(
        "Auto 1",
        "Auto 2",
        "Auto 3",
        "Auto 4",

    ))
        private set

    fun handleSearchAuto(){
        // TO DO
    }
    fun updateSearchAutoName(name: String){
        searchAutoName = name
    }

    fun updateStartingPoint(stop: String){
        startingPoint = stop
    }

    fun swapStops(){
        val temp = startingPoint
        startingPoint = destinationPoint
        destinationPoint = temp
    }

    fun updateDestinationPoint(it: String) {
        destinationPoint = it
    }

    fun handleFindAuto(){
        // TO DO
    }

}