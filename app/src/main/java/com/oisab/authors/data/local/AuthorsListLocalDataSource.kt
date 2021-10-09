package com.oisab.authors.data.local

interface AuthorsListLocalDataSource {

    suspend fun loadAllAuthorsAsync(): AuthorsListEntity
}