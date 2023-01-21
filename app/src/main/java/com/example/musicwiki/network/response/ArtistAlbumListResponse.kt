package com.example.musicwiki.network.response

import com.google.gson.annotations.SerializedName

data class ArtistAlbumListResponse(

    @SerializedName("topalbums")
    var topAlbums: TopAlbums? = null
)
