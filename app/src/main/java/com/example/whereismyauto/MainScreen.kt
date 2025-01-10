package com.example.whereismyauto

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.whereismyauto.nav.Item
import com.example.whereismyauto.nav.NavItem
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

    Scaffold(
        bottomBar = {
            BottomAppBar {
                BottomNavigationBar(navController = navHostController,navItems)
            }
        },

    ) {
        NavigationScreens(navController = navHostController)
    }
}

