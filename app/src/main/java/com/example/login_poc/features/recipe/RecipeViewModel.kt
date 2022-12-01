package com.example.login_poc.features.recipe

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login_poc.features.recipe.data.FoodRecipeOverview
import com.example.login_poc.features.recipe.data.FoodRecipeResult
import com.example.login_poc.features.recipe.data.GetRecipeListUseCase
import com.example.login_poc.util.NetworkResult
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

data class RecipeListState(
    val isLoading: Boolean = false,
    val recipes: ArrayList<FoodRecipeOverview> = ArrayList(),
    val error: String = ""
)

class RecipeViewModel(
    private val getRecipeListUseCase: GetRecipeListUseCase
) : ViewModel() {

    private val _recipeList = MutableLiveData<RecipeListState>()
    val recipeLiveData: LiveData<RecipeListState> = _recipeList

    fun getRecipesList() {
        getRecipeListUseCase().onEach { result ->
            when(result) {
                is NetworkResult.Success -> {
                    _recipeList.value = RecipeListState(recipes = result.data ?: ArrayList())
                    Log.i("Teste", "Successful")
                }
                is NetworkResult.Error -> {
                    _recipeList.value = RecipeListState(error = result.message ?: "An error has ocurred")
                    Log.i("Teste", "Error")
                }
                is NetworkResult.Loading -> {
                    _recipeList.value = RecipeListState(isLoading = true)
                    Log.i("Teste", "Loading")
                }
            }
        }.launchIn(viewModelScope)
    }
}