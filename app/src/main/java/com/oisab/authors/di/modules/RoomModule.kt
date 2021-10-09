package com.oisab.authors.di.modules

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.oisab.authors.data.local.AuthorsListDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    fun provideApplicationContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideAuthorsListDatabase(applicationContext: Context): AuthorsListDatabase =
        Room.databaseBuilder(
                applicationContext,
                AuthorsListDatabase::class.java,
                "authors_list_database"
            ).build()
}