package com.mycode.mealplanapp.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Features :Serializable {

    @SerializedName("meal")
    private lateinit var meal: Meal

    @SerializedName("restaurant")
    private lateinit var restaurant: Restaurant

    fun setMeal(meal : Meal ) {
        this.meal = meal
    }

    fun getMeal() : Meal {
        return meal
    }

    fun setRestaurant(restaurant : Restaurant ) {
        this.restaurant = restaurant
    }

    fun getRestaurant() : Restaurant {
        return restaurant
    }
}