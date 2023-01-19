package com.example.musicwiki.network.response

import com.example.musicwiki.network.model.Genre
import com.google.gson.annotations.SerializedName

data class GenreInfoResponse(
    @SerializedName("tag")
    var genreInfo: Genre? = null
)
