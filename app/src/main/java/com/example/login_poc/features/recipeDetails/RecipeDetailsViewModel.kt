package com.example.login_poc.features.recipeDetails

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.login_poc.features.recipesList.data.FoodRecipeDetail
import com.example.login_poc.util.FoodRecipeRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RecipeDetailsViewModel(
    private val repository: FoodRecipeRepositoryImpl,
    private val id: Int? = null
) : ViewModel() {
    private val _recipeDetail =
        MutableStateFlow<FoodRecipeDetail>(FoodRecipeDetail("", "", "", "", ""))
    val recipeDetail: StateFlow<FoodRecipeDetail> = _recipeDetail

    init {
        getRecipeDetail(2)
    }

    fun getRecipeDetail(idd: Int) {
        Log.i("Teste", "$id")
        viewModelScope.launch {
            val result: Result<FoodRecipeDetail> = kotlin.runCatching {
                val recipeDetail = repository.getRecipeDetail(idd)
                recipeDetail
            }
            _recipeDetail.value = result.getOrThrow()
        }
    }

}

//class MyViewModelFactory(private val id: Int) :
//    ViewModelProvider.NewInstanceFactory() {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T = RecipeDetailsViewModel(id) as T
//}