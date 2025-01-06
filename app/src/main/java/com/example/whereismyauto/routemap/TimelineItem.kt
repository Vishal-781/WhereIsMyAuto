package com.example.whereismyauto.routemap

import android.view.LayoutInflater
import android.widget.TextView
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.whereismyauto.R

@Composable
fun TimelineItem(
    stop: AutoStop
) {
    AndroidView(
        factory = { context ->
            LayoutInflater.from(context).inflate(R.layout.station_card, null)
        },
        modifier = Modifier.fillMaxWidth(),
        update = { view ->
            // Update view if needed
            view.findViewById<TextView>(R.id.station_name).text = stop.name
            view.findViewById<TextView>(R.id.av_time).text = stop.time
        }
    )
}