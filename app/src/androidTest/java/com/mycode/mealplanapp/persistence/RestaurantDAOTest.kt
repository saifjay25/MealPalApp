package com.mycode.mealplanapp.persistence

import com.mycode.mealplanapp.entity.Meal
import org.junit.Test
import UtilTest.Companion.meal
import android.database.sqlite.SQLiteConstraintException
import junit.framework.Assert.*
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mycode.mealplanapp.LiveDataTestUtility
import org.junit.Rule

class RestaurantDAOTest : RestaurantDatabaseTest() {

    @get:Rule
    val rule = InstantTaskExecutorRule()
    //Insert, Read, Delete
    @Test
    fun insertReadDelete() {
        val meal = Meal(meal)
        //add data
        getRestaurantDAO().addMeal(meal).blockingGet()
        //get data
        val liveDataTest = LiveDataTestUtility<Meal>()
        var insertedMeal = liveDataTest.getValue(getRestaurantDAO().getMeal())
        assertNotNull(insertedMeal)
        if (insertedMeal != null) {
            meal.setNum(insertedMeal.getNum())
            assertEquals(meal.getMealId(), insertedMeal.getMealId())
        }
        //removeAll
        getRestaurantDAO().removeMeal().blockingGet()
        insertedMeal = liveDataTest.getValue(getRestaurantDAO().getMeal())
        assertNull(insertedMeal)
    }
}