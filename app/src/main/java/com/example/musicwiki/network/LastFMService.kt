package com.example.musicwiki.network

import com.example.musicwiki.network.response.GenreListResponse
import com.example.musicwiki.utils.API_KEY
import com.example.musicwiki.utils.USER_AGENT
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LastFMService {
    @GET
    suspend fun getGenreListResponse(
        @Header("user-agent") userAgent: String = USER_AGENT,
        @Query("method") method: String = "tag.getTopTags",
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = "json"
    ): GenreListResponse
}
