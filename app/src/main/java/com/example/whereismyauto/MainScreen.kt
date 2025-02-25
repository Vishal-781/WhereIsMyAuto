package com.example.whereismyauto

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.whereismyauto.nav.Item
import com.example.whereismyauto.nav.NavItem
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import com.example.whereismyauto.navigation.DriverNavHost
import com.example.whereismyauto.navigation.UserNavHost
import com.example.whereismyauto.ui.theme.WhereIsMyAutoTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navHostController: NavHostController,
){
    val navItems = listOf(
        NavItem.Home,
        NavItem.MapView,
        NavItem.Search
    )
    // setup for checking the login state

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(80.dp),    // Match this height with your navigation bar height
                tonalElevation = 0.dp
            ) {
                BottomNavigationBar(navController = navHostController,navItems)
            }
        },

    ) {
        NavigationScreens(navController = navHostController)
    }
}



@Composable
fun DriverMainScreen(navHostController: NavHostController) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Driver-specific UI components like map for tracking,
            // vehicle status, route information, etc.
            DriverNavHost(navHostController = navHostController)
        }
    }
}

@Composable
fun UserMainScreen(navHostController: NavHostController) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // User-specific UI components like vehicle tracking map,
            // ETA information, booking interface, etc.
            UserNavHost(navHostController = navHostController)
        }
    }
}
