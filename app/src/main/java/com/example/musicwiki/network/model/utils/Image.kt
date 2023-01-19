package com.example.musicwiki.network.model.utils

import com.google.gson.annotations.SerializedName

data class Image(

    @SerializedName("#text")
    var url: String? = null,

    @SerializedName("size")
    var size: String? = null,
)
