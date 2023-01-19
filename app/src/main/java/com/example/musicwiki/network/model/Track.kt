package com.example.musicwiki.network.model

import com.example.musicwiki.network.model.utils.Attribute
import com.example.musicwiki.network.model.utils.Image
import com.google.gson.annotations.SerializedName

data class Track(

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("duration")
    var duration: String? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("streamable")
    var streamable: Streamable? = null,

    @SerializedName("artist")
    var artist: Artist? = null,

    @SerializedName("image")
    var images: List<Image>? = null,

    @SerializedName("@attr")
    var attribute: Attribute? = null

)

data class Streamable(

    @SerializedName("#text")
    var text: String? = null,

    @SerializedName("fulltrack")
    var fulltrack: String? = null
)
