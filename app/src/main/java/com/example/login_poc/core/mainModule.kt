package com.example.login_poc.core

import com.example.login_poc.features.recipeDetails.RecipeDetailsViewModel
import com.example.login_poc.features.recipesList.RecipeViewModel
import com.example.login_poc.util.FoodRecipeRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
     single { FoodRecipeRepositoryImpl() }

     viewModel { RecipeViewModel(get()) }
     viewModel { RecipeDetailsViewModel(get(), get()) }
}