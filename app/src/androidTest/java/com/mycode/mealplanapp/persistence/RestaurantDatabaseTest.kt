package com.mycode.mealplanapp.persistence

import android.content.Context
import org.junit.Assert.*
import androidx.test.core.app.ApplicationProvider
import androidx.room.Room
import org.junit.After
import org.junit.Before



abstract class RestaurantDatabaseTest{

    private lateinit var restaurantDatabase: RestaurantDatabase

    fun getRestaurantDAO() : RestaurantDAO{
        return restaurantDatabase.restaurantDAO()
    }

    @Before
    fun init() {
        restaurantDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext<Context>(),
            RestaurantDatabase::class.java
        ).build()
    }

    @After
    fun finish() {
        restaurantDatabase.close()
    }
}