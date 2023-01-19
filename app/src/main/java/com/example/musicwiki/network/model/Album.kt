package com.example.musicwiki.network.model

import com.example.musicwiki.network.model.utils.Attribute
import com.example.musicwiki.network.model.utils.Image
import com.google.gson.annotations.SerializedName

data class Album(

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("artist")
    var artist: Artist? = null,

    @SerializedName("image")
    var images: List<Image>? = null,

    @SerializedName("@attr")
    var attribute: Attribute? = null
)
