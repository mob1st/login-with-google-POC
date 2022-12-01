package com.example.login_poc.features.recipe.data

import android.content.Context
import com.example.login_poc.util.Constants.Companion.BASE_URL
import com.example.login_poc.util.TokenInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FoodRecipeRepositoryImpl(private val context: Context): FoodRecipeRepository {
    override fun makeRequest(): ApiService {
        val client = OkHttpClient.Builder()
            .addInterceptor(TokenInterceptor())
            .build()

        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    override suspend fun getRecipesList(): ArrayList<FoodRecipeOverview> {
        return makeRequest().getRecipesList()
    }

    override suspend fun getRecipeDetail(recipeId: String): FoodRecipeDetails {
        return makeRequest().getRecipeDetail(recipeId)
    }

    override suspend fun favoriteRecipe(recipeId: FavoriteRecipe): Boolean {
        TODO("Not yet implemented")
    }

}