package com.example.musicwiki.network.model.utils

import com.google.gson.annotations.SerializedName

data class Description(

    @SerializedName("summary")
    var summary: String? = null,

    @SerializedName("content")
    var content: String? = null,

    @SerializedName("published")
    var published: String? = null,
)
