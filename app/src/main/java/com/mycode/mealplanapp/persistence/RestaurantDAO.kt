package com.mycode.mealplanapp.persistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mycode.mealplanapp.entity.Meal
import io.reactivex.Single

@Dao
interface RestaurantDAO {

    @Query("SELECT * FROM mealIdTable LIMIT 1")
    fun getMeal() : LiveData<Meal>

    @Insert
    fun addMeal(meal : Meal): Single<Long>

    @Query("DELETE FROM mealIdTable")
    fun removeMeal(): Single<Int>
}
