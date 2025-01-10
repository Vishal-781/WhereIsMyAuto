package com.example.whereismyauto.automapview

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.whereismyauto.R
import com.example.whereismyauto.automapview.model.AutoRoute
import com.example.whereismyauto.ui.theme.BottomShapes
import com.example.whereismyauto.ui.theme.Shapes

import com.example.whereismyauto.ui.theme.typography
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.Polyline
import com.example.whereismyauto.automapview.createMarker as createMarker1


@Composable
fun AutoRouteMap(
    viewModel: AutoRoutesViewModel,
    onAutoClick: (AutoRoute) -> Unit
){
    val context = LocalContext.current
    val mapView = remember {
        MapViewConfig().createMapView(context)
    }
    val autoRoutes by viewModel.autoRoutes.collectAsState()

    AndroidView(
        factory = { mapView },
        update = { map ->
            map.overlays.clear()

            autoRoutes.forEach { route ->
                // Draw the fixed route path
                val routePath = Polyline().apply {
                    setPoints(listOf(route.startPoint) + route.waypoints + route.endPoint)
                    outlinePaint.color = route.color
                    outlinePaint.strokeWidth = 5f
                }
                map.overlays.add(routePath)

                // Add markers for start and end points
                val startMarker = createMarker1(
                    map = map,
                    position = route.startPoint,
                    title = "Start - ${route.name}",
                    iconRes = R.drawable.starting_point_marker
                )
                val endMarker = createMarker1(
                    map = map,
                    position = route.endPoint,
                    title = "End - ${route.name}",
                    iconRes = R.drawable.end_point_marker
                )
                map.overlays.addAll(listOf(startMarker, endMarker))

                // Add auto marker at current position
                val autoMarker = Marker(map).apply {
                    position = route.currentPosition
                    title = "Auto ${route.id} - ${route.name}"
                    setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                    icon = context.getDrawable(R.drawable.icons_auto_rickshaw)
                    setOnMarkerClickListener { _, _ ->
                        onAutoClick(route)
                        true
                    }
                }
                map.overlays.add(autoMarker)
            }

            map.invalidate()
        }

    )
}


private fun createMarker(
    map: MapView,
    position: GeoPoint,
    title: String,
    iconRes: Int
):Marker{
    return Marker(map).apply {
        this.position = position
        this.title = title
        setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        icon = map.context.getDrawable(iconRes)
    }

}
@Composable
fun AutoRouteMapScreen(
    viewModel: AutoRoutesViewModel
){
    Column(
        modifier = Modifier.fillMaxSize()
    ){
//        Surface(
//            modifier = Modifier.fillMaxWidth()
//                .height(80.dp),
//            shape = BottomShapes.small,
//            color = MaterialTheme.colorScheme.background,
//            shadowElevation = 4.dp,
//            tonalElevation = 4.dp
//        ) {
//            Row(
//                modifier = Modifier.fillMaxSize(),
//
//                verticalAlignment = Alignment.Bottom,
//            ) {
//                Text(
//                    text = "Map View",
//                    modifier = Modifier.padding(16.dp),
//                    style = typography.titleLarge,
//                    color = MaterialTheme.typography.bodySmall.color
//                )
//            }
//        }
        AutoRouteMap(
            viewModel = viewModel,
            onAutoClick = { route ->
                // Handle auto click
                println("Auto ${route.id} selected on ${route.name}")
            }
        )
    }
}

@Preview
@Composable
fun PreviewAutoRouteMapScreen(){
    AutoRouteMapScreen(
        viewModel = AutoRoutesViewModel()
    )
}

