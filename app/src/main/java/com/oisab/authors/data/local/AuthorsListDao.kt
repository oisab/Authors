package com.oisab.authors.data.local

import androidx.room.*

@Dao
interface AuthorsListDao {

    @Query("SELECT * FROM ${AuthorsListEntity.TABLE_NAME}")
    suspend fun getAllAuthorsAsync(): AuthorsListEntity

//    @Insert(entity = AuthorsListEntity::class, onConflict = OnConflictStrategy.REPLACE)
//    suspend fun addAuthorsListEntity(authorsListEntity: AuthorsListEntity)
//
//    @Delete(entity = AuthorsListEntity::class)
//    suspend fun deleteAuthorsListEntity(authorsListEntity: AuthorsListEntity)
}