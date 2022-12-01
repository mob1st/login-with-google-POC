package com.example.login_poc.features.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login_poc.di.mainModule
import com.example.login_poc.features.recipe.HomeScreen
import com.example.login_poc.features.favorite.ProfileScreen
import com.example.login_poc.features.recipe.RecipeViewModel
import com.example.login_poc.ui.theme.LoginpocTheme
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.compose.getViewModel
import org.koin.core.context.GlobalContext.startKoin

class MainActivity : ComponentActivity() {
    private val auth by lazy {
        Firebase.auth
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            androidLogger()
            androidContext(this@MainActivity)

            modules(mainModule)
        }

        setContent() {
            LoginpocTheme {
                Application()
            }
        }
    }

    @Composable
    fun Application() {
        val navController = rememberNavController()
        val viewModel = getViewModel<RecipeViewModel>()

        NavHost(navController = navController, startDestination = "login", builder = {
            composable("login", content = { LoginScreen(auth = auth, navController = navController)})
            composable("home", content = { HomeScreen(navController, viewModel)})
            composable("profile", content = { ProfileScreen(navController) })
        })
    }
}