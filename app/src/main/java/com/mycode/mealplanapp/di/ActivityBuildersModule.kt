package com.mycode.mealplanapp.di

import com.mycode.mealplanapp.ui.MainActivity
import com.mycode.mealplanapp.di.main.MainModule
import com.mycode.mealplanapp.di.main.MainViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [MainViewModelModule::class, MainModule::class])
    abstract fun contributesMainActivity(): MainActivity

}