package com.oisab.authors.data.local

class RoomAuthorsListDataSource(private val authorsListDao: AuthorsListDao) :
    AuthorsListLocalDataSource {

    override suspend fun loadAllAuthorsAsync(): AuthorsListEntity = authorsListDao.getAllAuthorsAsync()
}