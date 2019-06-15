package com.mycode.mealplanapp.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import androidx.room.PrimaryKey

@Entity(tableName = "mealIdTable")
class Meal {

    @PrimaryKey(autoGenerate = true)
    private var num = 0

    @NonNull
    @SerializedName("id")
    private lateinit var mealId: String

    @SerializedName("name")
    private lateinit var mealName: String

    @SerializedName("image_url")
    private lateinit var mealImage: String

    fun setMealId(mealId: String) {
        this.mealId = mealId
    }

    fun getMealId() : String {
        return mealId
    }

    fun setMealName(mealName : String ) {
        this.mealName = mealName
    }

    fun getMealName() : String {
        return mealName
    }

    fun setMealImage(mealImage : String ) {
        this.mealImage = mealImage
    }

    fun getMealImage() : String {
        return mealImage
    }

    fun getNum(): Int {
        return num
    }

    fun setNum(num: Int) {
        this.num = num
    }

    constructor(num : String , name : String , image : String){
        this.mealId = num
        this.mealImage = image
        this.mealName = name
    }

    constructor(meal : Meal){
        this.mealId = meal.mealId
        this.mealImage = meal.mealImage
        this.mealName = meal.mealName
    }
    constructor()

}