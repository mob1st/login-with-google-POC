package com.example.login_poc.features.recipe.data

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("findByIngredients?ingredients=meat")
    suspend fun getRecipesList(): ArrayList<FoodRecipeOverview>

    @GET("{id}/information")
    suspend fun getRecipeDetail(
        @Path("id") recipeId: String
    ): FoodRecipeDetails
}