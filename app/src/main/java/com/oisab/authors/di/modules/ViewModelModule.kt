package com.oisab.authors.di.modules

import androidx.lifecycle.ViewModelProvider
import com.oisab.authors.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory
}