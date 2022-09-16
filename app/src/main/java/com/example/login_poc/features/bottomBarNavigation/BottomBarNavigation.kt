package com.example.login_poc.features.bottomBarNavigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.login_poc.features.home.HomeScreen
import com.example.login_poc.features.login.LoginScreen
import com.example.login_poc.features.profile.ProfileScreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBarNavigation() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "login") {
        composable(route = BottomBarData.Home.route) {
            HomeScreen(navController)
        }
        composable(route = BottomBarData.Profile.route) {
            ProfileScreen(navController)
        }
    }
}

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
