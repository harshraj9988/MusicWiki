package com.example.musicwiki.network.model

import com.example.musicwiki.network.model.utils.Attribute
import com.example.musicwiki.network.model.utils.Image
import com.google.gson.annotations.SerializedName

data class Artist(

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("streamable")
    var streamable: String? = null,

    @SerializedName("image")
    var images: List<Image>? = null,

    @SerializedName("@attr")
    var attribute: Attribute? = null
)
