package com.example.musicwiki.network.response

import com.example.musicwiki.network.model.AlbumInfo
import com.google.gson.annotations.SerializedName

data class AlbumInfoResponse(
    @SerializedName("album")
    var albumInfo: AlbumInfo? = null
)
