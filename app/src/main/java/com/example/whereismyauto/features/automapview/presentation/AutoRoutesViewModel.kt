package com.example.whereismyauto.features.automapview.presentation

import android.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whereismyauto.features.automapview.presentation.model.AutoRoute
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.osmdroid.util.GeoPoint

class AutoRoutesViewModel : ViewModel(){
    private val routes = listOf(
        AutoRoute(
            id = 1,
            name = "Route A",
            startPoint = GeoPoint(23.809333167208457, 86.44255520765088),  // Campus Entry
            endPoint = GeoPoint(23.81936836720616, 86.43668794670991),    // Academic Block
            waypoints = listOf(
                GeoPoint(23.813225741440753, 86.44347477667206),
                GeoPoint(23.81555616519796, 86.44300986268115),
                GeoPoint(23.816040642362392, 86.44227453480725),
                GeoPoint(23.81645414372609, 86.4407870137448)
            ),
            color = Color.RED
        ),
        AutoRoute(
            id = 2,
            name = "Route B",
            startPoint = GeoPoint(23.809333167208457, 86.44255520765088),  // Campus Entry
            endPoint = GeoPoint(23.81058084607243, 86.43778667244364),    // Academic Block
            waypoints = listOf(
                GeoPoint(23.81123787415931, 86.44233791521778),
                GeoPoint(23.811169783889113, 86.4411823490541),
                GeoPoint(23.811910860174404, 86.43912241255573),
                GeoPoint(23.81086059187432, 86.43853769099216),

            ),
            color = Color.BLUE
        ),
//        AutoRoute(
//            id = 3,
//            name = "Route C",
//            endPoint = GeoPoint(23.809333167208457, 86.44255520765088),  // Campus Entry
//            startPoint  = GeoPoint(23.81058084607243, 86.43778667244364),    // Academic Block
//            waypoints = listOf(
//                GeoPoint(23.81086059187432, 86.43853769099216),
//                GeoPoint(23.811910860174404, 86.43912241255573),
//                GeoPoint(23.811169783889113, 86.4411823490541),
//                GeoPoint(23.81123787415931, 86.44233791521778),
//                ),
//            color = android.graphics.Color.BLUE
//        ),

        // Add more routes as needed
    )

    private val _autoRoutes = MutableStateFlow(routes)
    val autoRoutes = _autoRoutes.asStateFlow()

     fun startAutoMovement(){
        routes.forEach { route ->
            animateAuto(route)
        }
    }

    private fun  animateAuto(route: AutoRoute){
        viewModelScope.launch { // launch a coroutine in ViewModelScope
            val allPoints = listOf(route.startPoint) + route.waypoints + route.endPoint
            var currentIndex = 0
            var forward = true
            while (true) {
                // Move the auto to the next waypoint
                kotlinx.coroutines.delay(1000) // delay for 1 second
                if (forward) {
                    currentIndex++
                    if (currentIndex >= allPoints.size - 1) {
                        forward = false
                    }
                } else {
                    currentIndex--
                    if (currentIndex <= 0) {
                        forward = true
                    }
                }
                updateAutoPosition(route.id, allPoints[currentIndex])
            }
        }
    }

    private fun updateAutoPosition(
        autoId: Int,
        newPosition: GeoPoint
    ){
        _autoRoutes.value = _autoRoutes.value.map { route ->
            if (route.id == autoId) {
                route.copy(currentPosition = newPosition)
            } else {
                route
            }
        }
    }
}