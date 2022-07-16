package com.tamam.foodapplication.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig {

    // set interceptor
    private fun getInterceptor(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    private fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Get service from FoodListService
    fun getServiceFoodList(): FoodListService = getRetrofit().create(FoodListService::class.java)

    // Get service from MovieDetailService
//    fun getServiceDetailFood(): FoodDetailService = getRetrofit().create(FoodDetailService::class.java)
}