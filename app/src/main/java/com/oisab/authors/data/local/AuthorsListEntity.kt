package com.oisab.authors.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = AuthorsListEntity.TABLE_NAME)
data class AuthorsListEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "author_id")
    val authorId: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "subject_type")
    val subjectType: String,

    @ColumnInfo(name = "work_count")
    val workCount: Int,

    @ColumnInfo(name = "works")
    val works: String
) {
    companion object {
        const val TABLE_NAME = "authors_list"
    }
}