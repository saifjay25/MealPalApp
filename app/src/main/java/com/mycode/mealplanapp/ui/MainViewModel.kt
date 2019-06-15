package com.mycode.mealplanapp.ui
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.mycode.mealplanapp.entity.FeatureCollections
import com.mycode.mealplanapp.entity.Meal
import com.mycode.mealplanapp.network.MainAPI
import com.mycode.mealplanapp.persistence.RestaurantRepository
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import io.reactivex.Flowable
import io.reactivex.functions.Function


class MainViewModel @Inject
constructor(private var mainAPI: MainAPI, private var restaurantRepository: RestaurantRepository) : ViewModel() {

    fun restaurantAPICall(): LiveData<FeatureCollections> {
        return LiveDataReactiveStreams.fromPublisher(
            mainAPI.getRestaurants().subscribeOn(Schedulers.io())
        )
    }

    fun getMeal(): LiveData<Meal> {
        return restaurantRepository.getMeal()
    }

    fun insertMeal(meal: Meal): Flowable<Resource<Int>> {
        return restaurantRepository.insertMeal(meal)
    }

    fun deleteMeal(): Flowable<Resource<Int>> {
        return restaurantRepository.deleteMeal()

    }
}
