package com.example.login_poc.features.bottomBarNavigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(navController: NavHostController) {
    val tabs = listOf(
        BottomBarData.Home,
        BottomBarData.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        tabs.forEach { tab ->
            AddItem(
                tab = tab,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    tab: BottomBarData,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(
        label = {
            Text(text = tab.title)
        },
        icon = {
            Icon(
                imageVector = tab.icon,
                contentDescription = "Navigation icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == tab.route
        } == true,
        onClick = {
            navController.navigate(tab.route)
        }
    )
}
