package com.example.login_poc.features.recipesList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login_poc.features.recipesList.data.FoodRecipeResult
import com.example.login_poc.util.FoodRecipeRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RecipeViewModel(
    private val repository: FoodRecipeRepositoryImpl
) : ViewModel() {
    private val _recipeList = MutableStateFlow<FoodRecipeResult>(FoodRecipeResult(emptyList()))
    val recipeList: StateFlow<FoodRecipeResult> = _recipeList

    init {
        getRecipeList()
    }

    private fun getRecipeList() {
        viewModelScope.launch {
            val result: Result<FoodRecipeResult> = kotlin.runCatching {
                val foodRecipeData = repository.getRecipesList()
                foodRecipeData
            }
            _recipeList.value = result.getOrThrow()
        }
    }
}