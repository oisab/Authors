package com.oisab.authors.data.remote

class RetrofitAuthorsListDataSource(private val authorsApi: AuthorsApi):
    AuthorsListRemoteDataSource {

    override suspend fun getAuthorsListAsync(): AuthorsListResponse = authorsApi.getAuthorsListAsync()
}