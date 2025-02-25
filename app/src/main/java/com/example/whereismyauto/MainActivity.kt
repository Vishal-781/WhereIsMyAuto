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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.rememberNavController
import com.example.whereismyauto.data.UserRole
import com.example.whereismyauto.data.UserSessionManager
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

@Composable
fun RoleBasedMainScreen(
    navHostController: androidx.navigation.NavHostController,
    userSessionManager: UserSessionManager
) {
    // Check if user is logged in and get their role
    var userRole by remember { mutableStateOf<UserRole?>(null) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(key1 = Unit) {
        // Check if user is logged in
        val isLoggedIn = userSessionManager.isLoggedIn()

        if (isLoggedIn) {
            // Get user role from session manager
            userRole = userSessionManager.getUserRole()
        }

        isLoading = false
    }

    if (isLoading) {
        // Show a loading screen while checking login status
        LoadingScreen()
    } else if (userRole == null) {
        // Not logged in, show login screen
        LoginScreen(navHostController = navHostController, userSessionManager = userSessionManager)
    } else {
        // User is logged in, show appropriate UI based on role
        when (userRole) {
            UserRole.DRIVER -> DriverMainScreen(navHostController = navHostController)
            UserRole.USER -> UserMainScreen(navHostController = navHostController)
            else -> LoginScreen(navHostController = navHostController, userSessionManager = userSessionManager)
        }
    }
}

// You'll need to create these composables in separate files
@Composable
fun LoadingScreen() {
    // Your loading screen implementation
}

@Composable
fun LoginScreen(
    navHostController: androidx.navigation.NavHostController,
    userSessionManager: UserSessionManager
) {
    // Your login screen implementation with options for user/driver login
}