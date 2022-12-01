package com.example.login_poc.features.recipe.data

interface FoodRecipeRepository {
    fun makeRequest(): ApiService

    suspend fun getRecipesList(): ArrayList<FoodRecipeOverview>

    suspend fun getRecipeDetail(recipeId: String): FoodRecipeDetails

    suspend fun favoriteRecipe(recipeId: FavoriteRecipe): Boolean
}
