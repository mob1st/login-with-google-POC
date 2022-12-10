package com.example.login_poc.features.recipeDetails

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.login_poc.util.FoodRecipeRepositoryImpl
import org.koin.androidx.compose.inject
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun RecipeDetailsScreen(
    viewModel: RecipeDetailsViewModel,
    id: Int
) {
//    val foodRecipeRepositoryImpl: FoodRecipeRepositoryImpl by inject()
//
//    val sharedViewModel: RecipeDetailsViewModel = viewModel(factory = viewModelFactory {
//        RecipeDetailsViewModel(foodRecipeRepositoryImpl, id)
//    })

    //sharedViewModel

    viewModel.getRecipeDetail(id)
    val recipeDetail = viewModel.recipeDetail.value

    Log.i("Teste", "$recipeDetail")
}