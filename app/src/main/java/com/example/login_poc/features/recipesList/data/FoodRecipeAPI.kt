package com.example.login_poc.features.recipesList.data

import retrofit2.http.GET
import retrofit2.http.Path

interface RecipeList {
    @GET("recipes/complexSearch")
    suspend fun getRecipeList(): FoodRecipeResult

    @GET("recipes/{id}/information")
    suspend fun getRecipeDetail(
        @Path("id") id: Int
    ): FoodRecipeDetail
}

data class FoodRecipeResult(
    val results: List<FoodRecipesList>
)

data class FoodRecipesList(
    val id: Int,
    val title: String,
    val image: String,
    val imageType: String
)

data class FoodRecipeDetail(
    val id: String,
    val title: String,
    val descriptions: String,
    val image: String,
    val summary: String
)
