package com.example.musicwiki.network.response

import com.example.musicwiki.network.model.Artist
import com.google.gson.annotations.SerializedName

data class ArtistInfoResponse(
    @SerializedName("artist")
    var artistInfo: Artist? = null
)
