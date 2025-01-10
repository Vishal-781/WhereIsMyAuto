package com.example.whereismyauto

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.whereismyauto.nav.Item

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    navItems: List<Item>
) {
    var selectedItem by rememberSaveable {
        mutableStateOf(0)
    }

    NavigationBar(
        modifier = Modifier.fillMaxWidth()
            .padding(0.dp),
        tonalElevation = 8.dp,
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = if (index == selectedItem)
                            MaterialTheme.colorScheme.primary
                        else
                            MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
                    )
                },
                alwaysShowLabel = index == selectedItem,
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxHeight(),
                label = {
                    Text(
                        item.title,
                        style = TextStyle(
                            fontSize = 10.sp
                        ),
                        textAlign = TextAlign.Center,
                    )
                },
                selected = index == selectedItem,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                    indicatorColor = Color.Transparent
                ),
                onClick = {
                    selectedItem = index
                    navController.navigate(item.path) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}