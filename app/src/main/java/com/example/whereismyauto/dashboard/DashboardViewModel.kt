package com.example.whereismyauto.dashboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class DashboardViewModel: ViewModel() {
    var startingPoint: String by mutableStateOf("")
        private set

    var destinationPoint: String by mutableStateOf("")
        private set

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