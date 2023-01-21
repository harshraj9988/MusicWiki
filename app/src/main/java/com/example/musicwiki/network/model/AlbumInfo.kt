package com.example.musicwiki.network.model

import com.example.musicwiki.network.model.utils.Description
import com.example.musicwiki.network.model.utils.Image
import com.google.gson.annotations.SerializedName

data class AlbumInfo(

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("artist")
    var artist: String? = null,

    @SerializedName("tags")
    var genreList: Genres? = null,

    @SerializedName("image")
    var images: List<Image>? = null,

    @SerializedName("wiki")
    var description: Description? = null
)

data class Genres(

    @SerializedName("tag")
    var genres: List<Genre>? = null
)
