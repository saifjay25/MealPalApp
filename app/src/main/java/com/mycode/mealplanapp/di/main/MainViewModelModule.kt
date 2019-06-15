package com.mycode.mealplanapp.di.main

import androidx.lifecycle.ViewModel
import com.mycode.mealplanapp.di.ViewModelKey
import com.mycode.mealplanapp.ui.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel) : ViewModel
}