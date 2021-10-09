package com.oisab.authors.di.modules

import com.oisab.authors.data.SuggestedAuthorsListRepository
import com.oisab.authors.data.local.AuthorsListDatabase
import com.oisab.authors.data.local.AuthorsListLocalDataSource
import com.oisab.authors.data.local.RoomAuthorsListDataSource
import com.oisab.authors.data.remote.AuthorsApi
import com.oisab.authors.data.remote.AuthorsListRemoteDataSource
import com.oisab.authors.data.remote.RetrofitAuthorsListDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AuthorsListDataModule {

    @Provides
    @Singleton
    fun provideAuthorsListLocalDataSource(roomDatabase: AuthorsListDatabase): AuthorsListLocalDataSource = RoomAuthorsListDataSource(roomDatabase.authorsListDao())

    @Provides
    @Singleton
    fun provideAuthorsListRemoteDataSource(authorsApi: AuthorsApi): AuthorsListRemoteDataSource = RetrofitAuthorsListDataSource(authorsApi)

    @Provides
    @Singleton
    fun provideAuthorsListRepository(local: AuthorsListLocalDataSource, remote: AuthorsListRemoteDataSource): SuggestedAuthorsListRepository =
        SuggestedAuthorsListRepository(local, remote)
}