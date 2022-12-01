package com.example.login_poc.features.recipe

import InfoTemplate
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.login_poc.features.bottomBarNavigation.BottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: RecipeViewModel
) {
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        viewModel.getRecipesList()
        val livedata = viewModel.recipeLiveData
        Log.i("Teste", "${livedata.value?.recipes}")
    }
}