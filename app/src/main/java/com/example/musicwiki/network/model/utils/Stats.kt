package com.example.musicwiki.network.model.utils

import com.google.gson.annotations.SerializedName

data class Stats(

    @SerializedName("listeners")
    var followers: String? = null,

    @SerializedName("playcount")
    var playCount: String? = null
)
