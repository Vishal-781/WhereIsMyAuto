package com.example.whereismyauto.routemap

import androidx.lifecycle.ViewModel

class RouteMapViewModel : ViewModel() {

    var autoId: String = "1234"
        private set

    fun updateAutoID(id: String){
        autoId = "$id"
    }
    var stops : List<AutoStop>  = listOf(
        AutoStop("Kolkata", "8:05 PM", 0),
        AutoStop("Durgapur", "10:15 PM",  162),
        AutoStop("Durgapur", "10:15 PM",  162),
        AutoStop("Durgapur", "10:15 PM",  162),
        AutoStop("Durgapur", "10:15 PM",  162),
        AutoStop("Durgapur", "10:15 PM",  162),
        AutoStop("Durgapur", "10:15 PM",  162)
    )
        private set

    fun updateStops(stops: List<AutoStop>){
        this.stops = stops
    }





}