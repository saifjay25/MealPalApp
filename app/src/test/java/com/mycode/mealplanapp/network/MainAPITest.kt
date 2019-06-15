package com.mycode.mealplanapp.network

import com.mycode.mealplanapp.entity.FeatureCollections
import io.reactivex.Flowable
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainAPITest {

    @Mock
    private lateinit var mainAPI: MainAPI

    @BeforeEach
    fun init(){
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun getMainAPITest(){
        val featureCollections = FeatureCollections()
        val returnData : Flowable<FeatureCollections> =Flowable.just(featureCollections)
        Mockito.`when`(mainAPI.getRestaurants()).thenReturn(returnData)
        val returnValue : FeatureCollections = mainAPI.getRestaurants().blockingFirst()
        Mockito.verify(mainAPI).getRestaurants()
        Mockito.verifyNoMoreInteractions(mainAPI)
        Assertions.assertNotNull(returnValue)
    }
}