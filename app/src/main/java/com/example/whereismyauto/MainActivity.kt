package com.example.whereismyauto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.rememberNavController
import com.example.whereismyauto.ui.theme.WhereIsMyAutoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val isLightTheme = !isSystemInDarkTheme()

            WhereIsMyAutoTheme {
                val barColor = MaterialTheme.colorScheme.background.toArgb()

                // Configure edge-to-edge outside of composable
                enableEdgeToEdge(
//                    statusBarStyle = if (isLightTheme) {
//                        SystemBarStyle.light(barColor, barColor)
//                    } else {
//                        SystemBarStyle.dark(barColor)
//                    },
//                    navigationBarStyle = if (isLightTheme) {
//                        SystemBarStyle.light(barColor, barColor)
//                    } else {
//                        SystemBarStyle.dark(barColor)
//                    }
                )

                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(navHostController = navController)
                }
            }
        }
    }
}