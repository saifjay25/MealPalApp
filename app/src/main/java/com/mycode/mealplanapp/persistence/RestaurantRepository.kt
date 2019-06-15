package com.mycode.mealplanapp.persistence

import javax.inject.Inject
import javax.inject.Singleton
import androidx.lifecycle.LiveData
import com.mycode.mealplanapp.entity.Meal
import com.mycode.mealplanapp.ui.Resource
import io.reactivex.schedulers.Schedulers
import io.reactivex.Flowable
import io.reactivex.functions.Function

@Singleton
class RestaurantRepository @Inject constructor(restaurantDAO: RestaurantDAO) {

    private var restaurantDAO : RestaurantDAO = restaurantDAO

    fun getMeal(): LiveData<Meal> {
        return restaurantDAO.getMeal()
    }

    fun insertMeal(meal: Meal): Flowable<Resource<Int>> {
        return restaurantDAO.addMeal(meal)
            .map(object : Function<Long, Int> {
                override fun apply(t: Long): Int {
                    val l = t
                    return l.toInt()
                }
            })
            .onErrorReturn(object : Function<Throwable, Int> {
                override fun apply(t: Throwable): Int {
                    return -1
                }
            })
            .map(object : Function<Int, Resource<Int>> {
                override fun apply(t: Int): Resource<Int> {
                    return if (t > 0) {
                        Resource.success(t, "success")
                    } else{
                        Resource.error(null, "failure")
                    }
                }

            })
            .subscribeOn(Schedulers.io()).toFlowable()
    }

    fun deleteMeal(): Flowable<Resource<Int>> {
        return restaurantDAO.removeMeal()
            .onErrorReturn(object : Function<Throwable, Int> {
                override fun apply(t: Throwable): Int {
                    return -1
                }
            })
            .map(object : Function<Int, Resource<Int>> {
                override fun apply(t: Int): Resource<Int> {
                    return if (t > 0) {
                        Resource.success(t, "success")
                    } else{
                        Resource.error(null, "failure")
                    }
                }

            })
            .subscribeOn(Schedulers.io()).toFlowable()
    }

}