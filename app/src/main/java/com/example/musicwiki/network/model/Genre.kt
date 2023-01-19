package com.example.musicwiki.network.model

import android.util.EventLogTags
import com.google.gson.annotations.SerializedName

data class Genre(

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("count")
    var count: Int? = null,

    @SerializedName("reach")
    var reach: Int? = null,

    @SerializedName("total")
    var total: Int? = null,

    @SerializedName("wiki")
    var description: Description? = null
)

data class Description(

    @SerializedName("summary")
    var summary: String? = null,

    @SerializedName("content")
    var content: String? = null
)
