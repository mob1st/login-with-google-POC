package com.example.login_poc.di

import com.example.login_poc.features.recipe.RecipeViewModel
import com.example.login_poc.features.recipe.data.FoodRecipeDetails
import com.example.login_poc.features.recipe.data.FoodRecipeRepositoryImpl
import com.example.login_poc.features.recipe.data.GetRecipeListUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    single { FoodRecipeRepositoryImpl(context = androidContext()) }
    single { GetRecipeListUseCase(repository = get()) }

    viewModel {
        RecipeViewModel(getRecipeListUseCase = get())
    }

}