package com.mycode.mealplanapp.di

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import androidx.room.Room
import com.mycode.mealplanapp.persistence.RestaurantDAO
import com.mycode.mealplanapp.persistence.RestaurantDatabase
import com.mycode.mealplanapp.persistence.RestaurantRepository


@Module
object AppModule {

    @Singleton
    @JvmStatic
    @Provides
    fun providesGson() : Gson = GsonBuilder().create()

    @Singleton
    @JvmStatic
    @Provides
    fun provideRetrofitInstance(gson : Gson, client : OkHttpClient) : Retrofit
    {
        return Retrofit.Builder()
            .baseUrl("http://www.mocky.io")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    @Singleton
    @JvmStatic
    @Provides
    fun providesHTTPClient() :OkHttpClient
    {
        val builder = OkHttpClient.Builder()
        return builder.build()
    }

    @Singleton
    @JvmStatic
    @Provides
    fun provideRestaurantDatabase(application: Application): RestaurantDatabase {
        return Room.databaseBuilder(application, RestaurantDatabase::class.java, "database").build()

    }

    @Singleton
    @JvmStatic
    @Provides
    fun provideWeatherDao(restaurantDatabase: RestaurantDatabase): RestaurantDAO {
        return restaurantDatabase.restaurantDAO()
    }

    @Singleton
    @JvmStatic
    @Provides
    fun provideRestaurantRepository(restaurantDAO: RestaurantDAO): RestaurantRepository {
        return RestaurantRepository(restaurantDAO)
    }

}