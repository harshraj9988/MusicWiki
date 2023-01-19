package com.example.musicwiki.repository

import com.example.musicwiki.network.model.Genre

interface LastFMRepository {

    suspend fun getGenreList(): List<Genre>?
}
