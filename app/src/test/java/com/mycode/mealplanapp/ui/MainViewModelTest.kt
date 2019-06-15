package com.mycode.mealplanapp.ui
import com.mycode.mealplanapp.entity.Meal
import com.mycode.mealplanapp.network.MainAPI
import com.mycode.mealplanapp.persistence.RestaurantRepository
import org.junit.jupiter.api.Assertions.*
import io.reactivex.Flowable
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import androidx.lifecycle.MutableLiveData
import com.mycode.mealplanapp.InstantExecutorExtends
import com.mycode.mealplanapp.LiveDataTestUtil
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantExecutorExtends::class)
class MainViewModelTest{
    private var mainViewModel : MainViewModel? = null

    @Mock
    private lateinit var restaurantRepository : RestaurantRepository

    @Mock
    private lateinit var mainAPI : MainAPI

    companion object{
        private val meal : Meal = Meal(UtilTest.meal)
    }

    private fun <T> any(type : Class<T>): T {
        Mockito.any(type)
        return uninitialized()
    }

    private fun <T> uninitialized(): T = null as T
    @BeforeEach
    fun init() {
        MockitoAnnotations.initMocks(this)
        mainViewModel = MainViewModel(mainAPI,restaurantRepository)
    }

    @Test
    @Throws(Exception::class)
    fun insertMeal_returnRow() {
        // Arrange
        val insertRow = 1
        val returnedData = Flowable.just(Resource.success(insertRow, "success"))
        Mockito.`when`(restaurantRepository.insertMeal(any(Meal::class.java))).thenReturn(returnedData)

        val valueReturn = mainViewModel?.insertMeal(meal)?.blockingFirst()

        Mockito.verify(restaurantRepository).insertMeal(any(Meal::class.java))
        Mockito.verifyNoMoreInteractions(restaurantRepository)

        assertEquals(Resource.success(insertRow, "success"), valueReturn)
    }

    @Test
    @Throws(Exception::class)
    fun deleteMeal_returnRow() {
        // Arrange
        val insertRow = 1
        val returnedData = Flowable.just(Resource.success(insertRow, "success"))
        Mockito.`when`(restaurantRepository.deleteMeal()).thenReturn(returnedData)

        val valueReturn = mainViewModel?.deleteMeal()?.blockingFirst()

        Mockito.verify(restaurantRepository).deleteMeal()
        Mockito.verifyNoMoreInteractions(restaurantRepository)

        assertEquals(Resource.success(insertRow, "success"), valueReturn)
    }

    @Test
    @Throws(Exception::class)
    fun getMeal_returnMeal() {
        val liveDataTestUtil : LiveDataTestUtil<Meal> = LiveDataTestUtil()
        val returnedData : MutableLiveData<Meal> = MutableLiveData()
        returnedData.value = meal
        Mockito.`when`(restaurantRepository.getMeal()).thenReturn(returnedData)

        val data = liveDataTestUtil.getValue(mainViewModel!!.getMeal())

        assertEquals(meal, data)
    }

}