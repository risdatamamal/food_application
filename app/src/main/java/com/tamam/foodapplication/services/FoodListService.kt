package com.tamam.foodapplication.services

import com.tamam.foodapplication.model.FoodResponse
import retrofit2.Call
import retrofit2.http.GET

interface FoodListService {
    @GET("json/v1/1/filter.php?c=Seafood")
    fun getFoodsList(): Call<FoodResponse>
}