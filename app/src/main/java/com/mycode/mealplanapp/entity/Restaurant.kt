package com.mycode.mealplanapp.entity

import com.google.gson.annotations.SerializedName


class Restaurant {

    @SerializedName("name")
    private lateinit var restaurantName: String

    fun getRestaurantName() : String {
        return restaurantName
    }

    fun setRestaurantNmae(restaurantName : String ) {
        this.restaurantName = restaurantName
    }

}