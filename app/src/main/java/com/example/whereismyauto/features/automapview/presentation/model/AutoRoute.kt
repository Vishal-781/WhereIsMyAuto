package com.example.whereismyauto.features.automapview.presentation.model

import org.osmdroid.util.GeoPoint

data class AutoRoute(
    val id: Int,
    val name: String,
    val startPoint: GeoPoint,
    val endPoint: GeoPoint,
    val waypoints: List<GeoPoint>,
    val color: Int,
    val currentPosition: GeoPoint = startPoint
)