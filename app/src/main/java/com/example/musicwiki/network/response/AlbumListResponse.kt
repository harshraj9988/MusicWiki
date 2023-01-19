package com.example.musicwiki.network.response

import com.example.musicwiki.network.model.Album
import com.google.gson.annotations.SerializedName

data class AlbumListResponse(

    @SerializedName("albums")
    var topAlbums: TopAlbums? = null

)

data class TopAlbums(

    @SerializedName("album")
    var albums: List<Album>? = null
)
