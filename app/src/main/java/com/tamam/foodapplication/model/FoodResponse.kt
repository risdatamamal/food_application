package com.tamam.foodapplication.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class FoodResponse(
    @field:SerializedName("meals")
    val foods: List<Foods>,
) : Parcelable {
    constructor() : this(mutableListOf())
}

@Parcelize
data class Foods(

    @field:SerializedName("idMeal")
    val id: String? = null,

    @field:SerializedName("strMeal")
    val name: String? = null,

    @field:SerializedName("strMealThumb")
    val posterPath: String? = null,
) : Parcelable