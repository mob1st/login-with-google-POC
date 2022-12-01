package com.example.login_poc.features.recipe.data

data class FoodRecipeResult(
    val result: FoodRecipeOverview
)

data class FoodRecipeOverview(
    val id: Int,
    val title: String,
    val image: String
)

data class FoodRecipeDetails(
    val image: String
)

data class FavoriteRecipe(
    val id: String,
    val title: String,
    val descriptions: String,
    val image: String
)