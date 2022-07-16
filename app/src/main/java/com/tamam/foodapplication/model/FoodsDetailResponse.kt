package com.tamam.foodapplication.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class FoodsDetailResponse(
    val foods: Food
) : Parcelable

@Parcelize
data class Food(
    @field:SerializedName("idMeal")
    val id: String? = null,

    @field:SerializedName("strInstructions")
    val instruction: String? = null,

    @field:SerializedName("strMeal")
    val name: String? = null,

    @field:SerializedName("strMealThumb")
    val posterPath: String? = null,
) : Parcelable