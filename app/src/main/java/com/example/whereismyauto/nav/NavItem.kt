package com.example.whereismyauto.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Search

sealed class NavItem {
    object Home :
        Item(path = NavPath.HOME.toString(), title = NavTitle.HOME, icon = Icons.Filled.Home)
    object MapView :
        Item(path = NavPath.MAP_VIEW.toString(), title = NavTitle.MAP_VIEW, icon = Icons.Filled.Map)

    object Search :
        Item(path = NavPath.SEARCH.toString(), title = NavTitle.SEARCH, icon = Icons.Filled.Search)
//    object Settings : NavItem()
}