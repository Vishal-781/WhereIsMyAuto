package com.example.whereismyauto

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.whereismyauto.features.automapview.presentation.AutoRouteMapScreen
import com.example.whereismyauto.features.automapview.presentation.AutoRoutesViewModel
import com.example.whereismyauto.features.home.presentation.HomeScreen
import com.example.whereismyauto.nav.NavItem
import com.example.whereismyauto.features.search_dashboard.SearchScreen
import com.example.whereismyauto.features.search_dashboard.SearchViewModel

@Composable
fun NavigationScreens(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavItem.Home.path
    ){
        composable(NavItem.Home.path){
            HomeScreen()
        }
        composable(NavItem.MapView.path){
            AutoRouteMapScreen(AutoRoutesViewModel())
        }
        composable(NavItem.Search.path){
            SearchScreen(SearchViewModel())
        }

    }
}