package com.oisab.authors.data.remote

import retrofit2.http.GET

interface AuthorsApi {
    @GET("./subjects/architecture.json")
    suspend fun getAuthorsListAsync(): AuthorsListResponse
}