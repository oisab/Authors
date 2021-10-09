package com.oisab.authors.di

import android.app.Application
import com.oisab.authors.*
import com.oisab.authors.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(modules = [AndroidInjectionModule::class,
    AuthorsListDataModule::class,
    SuggestedAuthorsModule::class,
    ActivityBindingModule::class,
    RoomModule::class,
    ViewModelModule::class,
    RemoteModule::class])

@Singleton
interface AppComponent : AndroidInjector<AuthorsApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}