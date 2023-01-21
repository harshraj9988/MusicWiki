package com.example.musicwiki.network.response

import com.google.gson.annotations.SerializedName

data class ArtistTrackListResponse(

    @SerializedName("toptracks")
    var topTracks: TopTracks? = null
)
