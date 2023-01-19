package com.example.musicwiki.repository

import android.util.Log
import com.example.musicwiki.network.LastFMService
import com.example.musicwiki.network.model.GenreDto
import com.example.musicwiki.network.response.GenreListResponse

class LastFMRepositoryImpl(
    private val lastFMService: LastFMService
) : LastFMRepository {
    override suspend fun getGenreList(): List<GenreDto>? {
        val genreListResponse: GenreListResponse = lastFMService.getGenreListResponse()
        Log.e("GenreListResponse", genreListResponse.errorMessage?:"Success" )
        return genreListResponse.topGenres?.genres
    }
}
