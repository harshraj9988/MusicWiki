package com.example.musicwiki.network.response

import com.example.musicwiki.network.model.Artist
import com.google.gson.annotations.SerializedName

data class ArtistListResponse(

    @SerializedName("topartists")
    var topArtists: TopArtists? = null
)

data class TopArtists(

    @SerializedName("artist")
    var artists: List<Artist>? = null
)
