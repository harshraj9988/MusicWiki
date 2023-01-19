package com.example.musicwiki.network.response

import com.example.musicwiki.network.model.GenreDto
import com.google.gson.annotations.SerializedName

data class GenreListResponse(

    @SerializedName("toptags")
    var topGenres: TopGenres? = null,

    @SerializedName("message")
    var errorMessage: String? = null,

    @SerializedName("error")
    var errorCount: Int? = null

)

data class TopGenres(

    @SerializedName("@attr")
    var attributes: Attributes? = null,

    @SerializedName("tag")
    var genres: List<GenreDto>? = null
)

data class Attributes(

    @SerializedName("offset")
    var offset: Int? = null,

    @SerializedName("num_res")
    var numberOfResults: Int? = null,

    @SerializedName("total")
    var total: Int? = null
)
