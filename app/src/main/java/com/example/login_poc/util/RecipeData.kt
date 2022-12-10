package com.example.login_poc.util

data class RecipeData(
    val accessToken: String,
    val refreshToken: String
)

data class ErrorToken(
    val error: String,
)
