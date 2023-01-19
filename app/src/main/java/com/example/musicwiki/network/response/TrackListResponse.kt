package com.example.musicwiki.network.response

import com.example.musicwiki.network.model.Track
import com.google.gson.annotations.SerializedName

data class TrackListResponse(

    @SerializedName("tracks")
    var topTracks: TopTracks? = null
)

data class TopTracks(

    @SerializedName("track")
    var tracks: List<Track>? = null
)
