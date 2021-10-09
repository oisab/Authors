package com.oisab.authors.data

import com.oisab.authors.data.local.AuthorsListLocalDataSource
import com.oisab.authors.data.remote.AuthorsListRemoteDataSource
import com.oisab.authors.data.remote.AuthorsListResponse

class SuggestedAuthorsListRepository(
    private val authorsListLocalDataSource: AuthorsListLocalDataSource,
    private val authorsListRemoteDataSource: AuthorsListRemoteDataSource
) {

    suspend fun fetchAuthorsListAsync(): AuthorsListResponse = authorsListRemoteDataSource.getAuthorsListAsync()
}