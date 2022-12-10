package com.example.login_poc.util

import com.example.login_poc.features.recipesList.data.FoodRecipeDetail
import com.example.login_poc.features.recipesList.data.FoodRecipeRepository
import com.example.login_poc.features.recipesList.data.FoodRecipeResult
import com.example.login_poc.features.recipesList.data.RecipeList
import com.example.login_poc.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class FoodRecipeRepositoryImpl() : FoodRecipeRepository {
    private fun makeRequest(): RecipeList {
        val client = OkHttpClient.Builder()
            .addInterceptor(TokenInterceptor())
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    override suspend fun getRecipesList(): FoodRecipeResult {
        return makeRequest().getRecipeList()
    }

    override suspend fun getRecipeDetail(id: Int): FoodRecipeDetail {
        return makeRequest().getRecipeDetail(12)
    }

}


