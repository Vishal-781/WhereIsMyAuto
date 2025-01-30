package com.example.whereismyauto.features.home.presentation

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp
import com.example.whereismyauto.features.home.presentation.model.AutoLine
import com.example.whereismyauto.features.home.presentation.model.AutoStation
import com.example.whereismyauto.ui.theme.color_background
import com.example.whereismyauto.ui.theme.color_black
import com.example.whereismyauto.ui.theme.color_white
import com.example.whereismyauto.ui.theme.typography

@Composable
fun AutoTransitChart(
    viewModel: HomeViewModel,
    onStationClick: (AutoStation) -> Unit
) {
    val autoLines by viewModel.autoLines.collectAsState()  // Define a horizontal scroll state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color_background),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Draw metro lines
            autoLines.forEach { line ->
                // Draw line path
                val path = Path().apply {
                    line.path.forEachIndexed { index, point ->
                        if (index == 0) {
                            moveTo(point.x, point.y)
                        } else {
                            lineTo(point.x, point.y)
                        }
                    }
                }

                drawPath(
                    path = path,
                    color = line.color,
                    style = Stroke(width = 15f)
                )

                // Draw stations
                line.stations.forEach { station ->
                    if (station.isInterchange) {
                        // Draw interchange station (larger)
                        drawCircle(
                            color = Color.White,
                            radius = 25f,
                            center = station.position,
                            style = Stroke(width = 4f)
                        )
                        drawCircle(
                            color = line.color,
                            radius = 20f,
                            center = station.position
                        )
                    } else {
                        // Draw regular station
                        drawCircle(
                            color = Color.White,
                            radius = 15f,
                            center = station.position,
                            style = Stroke(width = 4f)
                        )
                        drawCircle(
                            color = line.color,
                            radius = 12f,
                            center = station.position
                        )
                    }
                    // Draw station label
                    drawContext.canvas.nativeCanvas.apply {
                        val paint = Paint().apply {
                            color = android.graphics.Color.BLACK
                            textSize = 16f
                            textAlign = Paint.Align.LEFT
                            isAntiAlias = true
                        }

                        // Position the text below the station circle
                        val textOffset = 25f
                        drawText(
                            station.name,
                            station.position.x - (paint.measureText(station.name) / 2),
                            station.position.y + textOffset,
                            paint
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AutoChartLegend(metroLines: List<AutoLine>) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(color_white)
    ) {
        Text(
            text = "Metro Lines",
            style = typography.titleLarge,
            color = color_black
        )
        Spacer(modifier = Modifier.height(8.dp))

        metroLines.forEach { line ->
            Row(
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(line.color, CircleShape)
                )
                Text(line.name)
            }
        }
    }
}
@Composable
fun AutoLinesChartScreen(

) {
    val viewModel = remember { HomeViewModel() }
    val metroLines by viewModel.autoLines.collectAsState()
    Column {
        AutoTransitChart(
            viewModel = viewModel,
            onStationClick = { station ->
                // Handle station click
                println("Station clicked: ${station.name}")
            }
        )
        AutoChartLegend(metroLines)
    }
}