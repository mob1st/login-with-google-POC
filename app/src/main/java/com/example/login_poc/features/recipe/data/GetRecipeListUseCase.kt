package com.example.login_poc.features.recipe.data

import android.util.Log
import com.example.login_poc.util.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class GetRecipeListUseCase(private val repository: FoodRecipeRepositoryImpl) {
    operator fun invoke(): Flow<NetworkResult<ArrayList<FoodRecipeOverview>>> = flow {
        try {
            emit(NetworkResult.Loading())
            val recipes = repository.getRecipesList()
            emit(NetworkResult.Success(recipes))
        } catch (e: HttpException) {
            emit(NetworkResult.Error(e.message() ?: "Error has ocurred"))
        }
    }
}