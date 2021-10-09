package com.oisab.authors.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        AuthorsListEntity::class
    ], version = 1, exportSchema = true
)
abstract class AuthorsListDatabase : RoomDatabase() {

    abstract fun authorsListDao(): AuthorsListDao
}