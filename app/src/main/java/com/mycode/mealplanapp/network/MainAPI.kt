package com.mycode.mealplanapp.network

import com.mycode.mealplanapp.entity.FeatureCollections
import io.reactivex.Flowable
import retrofit2.http.GET
interface MainAPI {

    @GET("/v2/5b6379d5300000cd33650429.json")
    fun getRestaurants(): Flowable<FeatureCollections>

}