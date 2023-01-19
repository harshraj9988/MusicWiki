package com.example.musicwiki.network.model

import com.example.musicwiki.network.model.utils.Attribute
import com.example.musicwiki.network.model.utils.Description
import com.example.musicwiki.network.model.utils.Image
import com.example.musicwiki.network.model.utils.Stats
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
    var attribute: Attribute? = null,

    @SerializedName("stats")
    var stats: Stats? = null,

    @SerializedName("bio")
    var bio: Description? = null,
)

