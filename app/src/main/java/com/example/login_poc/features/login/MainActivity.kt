package com.example.login_poc.features.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login_poc.features.bottomBarNavigation.BottomBarNavigation
import com.example.login_poc.features.bottomBarNavigation.BottomNavGraph
import com.example.login_poc.features.home.HomeScreen
import com.example.login_poc.features.profile.ProfileScreen
import com.example.login_poc.ui.theme.LoginpocTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {
    private val auth by lazy {
        Firebase.auth
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent() {
            LoginpocTheme {
                Application()
            }
        }
    }

    @Composable
    fun Application() {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "login", builder = {
            composable("login", content = { LoginScreen(auth = auth, navController = navController)})
            composable("home", content = { HomeScreen(navController)})
            composable("profile", content = { ProfileScreen(navController) })
        })
    }
}