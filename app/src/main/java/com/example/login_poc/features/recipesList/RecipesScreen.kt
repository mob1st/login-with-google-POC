package com.example.login_poc.features.recipesList

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.login_poc.ds.organisms.CardComponent
import com.example.login_poc.features.bottomBarNavigation.BottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipesScreen(
    navController: NavHostController,
    viewModel: RecipeViewModel
) {
    val recipeList = viewModel.recipeList.value.results

    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(
                recipeList,
                key = { _, item -> item.id }
            ) { _, item ->
                CardComponent(
                    recipeName = item.title,
                    image = item.image,
                    onClick = {
                        navController.navigate("recipeDetails/{id}".replace(
                            oldValue = "{id}",
                            newValue = item.id.toString()
                        ))
                    })
            }
        }
    }
}