package com.mycode.mealplanapp.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class FeatureCollections :Serializable {

    @SerializedName("features")
    private lateinit var features : MutableList<Features>

    fun getFeatures() :  MutableList<Features> {
        return features
    }

    fun setFeatures(features :  MutableList<Features>) {
        this.features = features
    }
}