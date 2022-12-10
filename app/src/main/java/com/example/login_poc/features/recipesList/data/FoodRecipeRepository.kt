package com.example.login_poc.features.recipesList.data

interface FoodRecipeRepository {
    suspend fun getRecipesList(): FoodRecipeResult

    suspend fun getRecipeDetail(id: Int): FoodRecipeDetail
}