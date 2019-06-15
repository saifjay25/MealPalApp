package com.mycode.mealplanapp.persistence

import UtilTest.Companion.meal
import androidx.lifecycle.MutableLiveData
import com.mycode.mealplanapp.InstantExecutorExtends
import com.mycode.mealplanapp.LiveDataTestUtil
import com.mycode.mealplanapp.entity.Meal
import com.mycode.mealplanapp.ui.MainViewModelTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.junit.jupiter.api.Assertions
import com.mycode.mealplanapp.ui.Resource
import io.reactivex.Single
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.Mockito.verifyNoMoreInteractions

@Suppress("UNCHECKED_CAST")
@ExtendWith(InstantExecutorExtends::class)
class RestaurantRepositoryTest{

    companion object{
        private val meal : Meal = Meal(UtilTest.meal)
    }

    private lateinit var restaurantRepository : RestaurantRepository
    @Mock
    private lateinit var restaurantDAO : RestaurantDAO

    @BeforeEach
    fun init(){
        MockitoAnnotations.initMocks(this)
        restaurantRepository = RestaurantRepository(restaurantDAO)
    }

    private fun <T> any(type : Class<T>): T {
        Mockito.any(type)
        return uninitialized()
    }

    private fun <T> uninitialized(): T = null as T

    //add meal then verify correct method, then confirm new row is inserted
    @Test
    @Throws(Exception::class)
    fun insertMeal_returnRow() {
        val insertRow = 1L
        val returnData = Single.just(insertRow)
        Mockito.`when`(restaurantDAO.addMeal(any(Meal::class.java))).thenReturn(returnData)

        val valueReturn = restaurantRepository.insertMeal(meal).blockingFirst()

        Mockito.verify(restaurantDAO).addMeal(any(Meal::class.java))
        verifyNoMoreInteractions(restaurantDAO)

        System.out.println(valueReturn.data)
        Assertions.assertEquals(Resource.success(1, "success"), valueReturn)
    }

    @Test
    @Throws(Exception::class)
    fun insertMealReturnFailure(){
        val insertFail = -1L
        val returnData = Single.just(insertFail)
        Mockito.`when`(restaurantDAO.addMeal(any(Meal::class.java))).thenReturn(returnData)

        val valueReturn = restaurantRepository.insertMeal(meal).blockingFirst()

        Mockito.verify(restaurantDAO).addMeal(any(Meal::class.java))
        verifyNoMoreInteractions(restaurantDAO)

        Assertions.assertEquals(Resource.error(null, "failure"), valueReturn)
    }

    @Test
    @Throws(Exception::class)
    fun deleteMeal_returnRow() {
        val deleted = 1
        Mockito.`when`(restaurantDAO.removeMeal()).thenReturn(Single.just(deleted))

        val returnVal = restaurantRepository.deleteMeal().blockingFirst()

        Mockito.verify(restaurantDAO).removeMeal()
        verifyNoMoreInteractions(restaurantDAO)

        Assertions.assertEquals(Resource.success(1, "success"), returnVal)
    }

    @Test
    @Throws(Exception::class)
    fun deleteMealReturnFailure(){
        val insertFail = -1
        val returnData = Single.just(insertFail)
        Mockito.`when`(restaurantDAO.removeMeal()).thenReturn(returnData)

        val valueReturn = restaurantRepository.deleteMeal().blockingFirst()

        Mockito.verify(restaurantDAO).removeMeal()
        verifyNoMoreInteractions(restaurantDAO)

        Assertions.assertEquals(Resource.error(null, "failure"), valueReturn)
    }

    @Test
    @Throws(Exception::class)
    fun getMeal_returnMeal() {
        val liveDataTestUtil : LiveDataTestUtil<Meal> = LiveDataTestUtil()
        val returnedData : MutableLiveData<Meal> = MutableLiveData()
        returnedData.value = meal
        Mockito.`when`(restaurantDAO.getMeal()).thenReturn(returnedData)

        val data = liveDataTestUtil.getValue(restaurantRepository.getMeal())

        Assertions.assertEquals(meal, data)
    }
}