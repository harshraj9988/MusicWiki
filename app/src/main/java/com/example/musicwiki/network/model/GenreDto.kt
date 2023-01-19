package com.example.musicwiki.network.model

import com.google.gson.annotations.SerializedName

data class GenreDto(

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("count")
    var count: Int? = null,

    @SerializedName("reach")
    var reach: Int? = null,
)
