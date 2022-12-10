package com.example.login_poc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login_poc.core.mainModule
//import com.example.login_poc.di.mainModule
import com.example.login_poc.features.recipesList.RecipesScreen
import com.example.login_poc.features.favorite.ProfileScreen
import com.example.login_poc.features.login.LoginScreen
import com.example.login_poc.features.recipeDetails.RecipeDetailsScreen
import com.example.login_poc.features.recipeDetails.RecipeDetailsViewModel
import com.example.login_poc.features.recipesList.RecipeViewModel
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
        val recipeViewModel = getViewModel<RecipeViewModel>()
        val recipeDetailsViewModel = getViewModel<RecipeDetailsViewModel>()

        NavHost(navController = navController, startDestination = "login", builder = {
            composable("login", content = { LoginScreen(auth = auth, navController = navController) })
            composable("home", content = { RecipesScreen(navController, recipeViewModel)})
            composable("profile", content = { ProfileScreen(navController) })
            composable("recipeDetails/{id}") {
                val recipeId = it.arguments?.getString("id")
                recipeId?.let {
                    RecipeDetailsScreen( recipeDetailsViewModel,id = recipeId.toInt())
                }
            }
        })
    }
}