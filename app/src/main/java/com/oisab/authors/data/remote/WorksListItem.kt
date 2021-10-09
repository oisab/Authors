package com.oisab.authors.data.remote

import com.google.gson.annotations.SerializedName

data class WorksListItem(
    val key: String,
    val title: String,

    @SerializedName("edition_content")
    val editionContent: String,

    @SerializedName("cover_id")
    val coverId: String,

    @SerializedName("cover_edition_key")
    val coverEditionKey: String
)