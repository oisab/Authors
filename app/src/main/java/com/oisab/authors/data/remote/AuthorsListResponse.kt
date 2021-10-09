package com.oisab.authors.data.remote

import com.google.gson.annotations.SerializedName

data class AuthorsListResponse(
    val name: String,

    @SerializedName("subject_type")
    val subjectType: String,

    @SerializedName("work_count")
    val workCount: Int,

    @SerializedName("works")
    val works: List<WorksListItem>
)