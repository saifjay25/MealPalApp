package com.mycode.mealplanapp.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mycode.mealplanapp.entity.Meal

@Database(entities = [Meal::class], version = 4)
abstract class RestaurantDatabase : RoomDatabase() {

    abstract fun restaurantDAO(): RestaurantDAO

    companion object {

        private var instance : RestaurantDatabase? = null

        @Synchronized fun  getInstance(context: Context) : RestaurantDatabase {
            if(instance ==null){

                instance = Room.databaseBuilder(context.applicationContext,
                    RestaurantDatabase::class.java,"database").fallbackToDestructiveMigration().build()
            }
            return instance as RestaurantDatabase
        }
    }

}