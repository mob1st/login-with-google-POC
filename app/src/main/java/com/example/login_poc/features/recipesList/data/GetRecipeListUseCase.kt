package com.example.login_poc.features.recipesList.data

//
//class GetRecipeListUseCase(private val repository: FoodRecipeRepositoryImpl) {
//    operator fun invoke(): Flow<Resource<ArrayList<FoodRecipesList>>> = flow {
//        try {
//            emit(Resource.Loading())
//            val recipes = repository.getRecipesList()
//            Log.i("Teste", "GetRecipeListUseCase: $recipes")
//            emit(Resource.Success(recipes))
//        } catch (e: HttpException) {
//            emit(Resource.Error())
//        }
//    }
//}