package com.tamam.foodapplication.services

import com.tamam.foodapplication.model.FoodsDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodDetailService {
    @GET("json/v1/1/lookup.php")
    fun getDetailFood(@Query("i") id: String): Call<FoodsDetailResponse>
}