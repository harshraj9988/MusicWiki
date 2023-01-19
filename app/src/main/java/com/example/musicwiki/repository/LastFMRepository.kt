package com.example.musicwiki.repository

import com.example.musicwiki.network.model.GenreDto

interface LastFMRepository {

    suspend fun getGenreList(): List<GenreDto>?
}
