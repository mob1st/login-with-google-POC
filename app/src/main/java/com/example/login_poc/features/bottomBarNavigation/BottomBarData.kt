package com.example.login_poc.features.bottomBarNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Login
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarData(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarData(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Profile : BottomBarData(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
}

sealed class AppRouteDestination(val route: String) {
    object RecipeDetails: AppRouteDestination(
        route = "recipeDetails/{id}"
    )
}
