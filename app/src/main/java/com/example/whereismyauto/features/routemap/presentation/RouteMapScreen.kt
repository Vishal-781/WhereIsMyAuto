package com.example.whereismyauto.features.routemap.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whereismyauto.ui.theme.Shapes
import com.example.whereismyauto.ui.theme.color_primary
import com.example.whereismyauto.ui.theme.color_tool_bar
import com.example.whereismyauto.ui.theme.color_white
import com.example.whereismyauto.ui.theme.typography

@Composable
fun RouteMapScreen(
    viewModel: RouteMapViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = color_white),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color_tool_bar)
                .height(80.dp)
                .border(1.dp, color_white, Shapes.small),
            verticalAlignment = Alignment.CenterVertically,


            ){
            Text(
                text = "Live Status",
                modifier = Modifier.padding(16.dp),
                style = typography.titleLarge,
                color = color_white
            )
        }

        Row (
            modifier = Modifier.padding(4.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ){
            Text(
                text = "${viewModel.autoId}: Main gate ----> Aquamarine",
//                style = typography.titleLarge
            )
        }

        Row(
            modifier = Modifier
                .background(color = color_primary)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Text(
                modifier = Modifier.padding(4.dp),
                text = "Arrival Time",
                style = typography.titleSmall
            )
            Text(
                modifier = Modifier.padding(4.dp),
                text = "Stop Name",
                style = typography.titleSmall
            )
            Text(
                modifier = Modifier.padding(4.dp),
                text = "Distance",
                style = typography.titleSmall
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            items(viewModel.stops) { stop ->
                TimelineItem(stop)
            }
        }

    }
}

@Preview
@Composable
fun PreviewRouteMapScreen() {
    RouteMapScreen(viewModel = RouteMapViewModel())
}