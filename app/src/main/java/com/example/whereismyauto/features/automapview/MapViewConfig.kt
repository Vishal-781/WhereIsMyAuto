package com.example.whereismyauto.features.automapview

import android.content.Context
import android.preference.PreferenceManager
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.CustomZoomButtonsController

class MapViewConfig {
    var homeLatitude = 23.809333167208457
    var homeLongitude = 86.44255520765088
    public fun createMapView(context: Context): MapView {
        // Initialize OSMDroid configuration
        Configuration.getInstance().apply {
            load(context, PreferenceManager.getDefaultSharedPreferences(context))
            userAgentValue = context.packageName // Set user agent to your app's package name
        }

        return MapView(context).apply {
            // Set the tile source (standard OSM map style)
            setTileSource(TileSourceFactory.MAPNIK)

            // Enable multi-touch controls
            setMultiTouchControls(true)

            // Configure zoom controls
            zoomController.setVisibility(CustomZoomButtonsController.Visibility.SHOW_AND_FADEOUT)

            // Set minimum and maximum zoom levels
            minZoomLevel = 4.0
            maxZoomLevel = 20.0


            // Configure map scale bar
            setBuiltInZoomControls(true)

            // Optional: Disable hardware acceleration for better performance
            setLayerType(android.view.View.LAYER_TYPE_SOFTWARE, null)


            // Set default zoom level and center on the home location
            val mapController = controller
            mapController.setZoom(17.0) // Set zoom level
            mapController.setCenter(GeoPoint(homeLatitude, homeLongitude))
        }
    }

}
