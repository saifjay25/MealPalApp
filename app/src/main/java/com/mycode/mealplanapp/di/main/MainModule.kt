package com.mycode.mealplanapp.di.main

import com.mycode.mealplanapp.network.MainAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object MainModule {

    @Provides
    @JvmStatic
    fun provideMainAPI (retrofit : Retrofit): MainAPI
    {
        return retrofit.create(MainAPI::class.java)
    }
}