package com.mycode.mealplanapp.di

import androidx.lifecycle.ViewModelProvider
import com.mycode.mealplanapp.viewmodel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    internal abstract fun bindViewModelFactory(viewModelsProvidersFactory: ViewModelProviderFactory) : ViewModelProvider.Factory
}