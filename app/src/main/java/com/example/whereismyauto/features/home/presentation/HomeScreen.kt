package com.example.whereismyauto.features.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import com.example.whereismyauto.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whereismyauto.ui.theme.BottomShapes
import com.example.whereismyauto.ui.theme.typography


// Usage example
@Composable
fun HomeScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp),
            shape = BottomShapes.small,
            color = MaterialTheme.colorScheme.background,
            shadowElevation = 4.dp,
            tonalElevation = 4.dp
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "ETA Chart",
                    modifier = Modifier.padding(top = 36.dp, start = 16.dp, bottom = 8.dp),
                    style = typography.titleMedium,
                    color = MaterialTheme.colorScheme.primaryContainer
                )
                // add profile icon
                Icon(
                    modifier = Modifier.padding(vertical = 16.dp, horizontal = 24.dp)
                        .height(24.dp)
                        .width(24.dp),
                    painter = painterResource(id = R.drawable.profile_icon),
                    contentDescription = "Profile",
                    tint = MaterialTheme.colorScheme.primaryContainer
                )

            }
        }
        AutoLinesChartScreen()

    }

}
@Preview
@Composable
fun PreviewMetroMapScreen() {

    AutoLinesChartScreen()
}
