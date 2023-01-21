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

    @SerializedName("artist")
    var artist: Artist? = null,

    @SerializedName("image")
    var images: List<Image>? = null,

    @SerializedName("@attr")
    var attribute: Attribute? = null,

    @SerializedName("playcount")
    var playCount: String? = null,

    @SerializedName("listeners")
    var listeners: String? = null,

)

