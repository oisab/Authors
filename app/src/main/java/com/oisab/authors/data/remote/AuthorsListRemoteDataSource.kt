package com.oisab.authors.data.remote

interface AuthorsListRemoteDataSource {

    suspend fun getAuthorsListAsync(): AuthorsListResponse
}