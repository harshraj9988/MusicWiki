package com.example.musicwiki.repository

import com.example.musicwiki.network.model.Album
import com.example.musicwiki.network.model.Artist
import com.example.musicwiki.network.model.Genre
import com.example.musicwiki.network.model.Track

interface LastFMRepository {

    suspend fun getGenreList(): List<Genre>?

    suspend fun getGenreInfo(query: String): Genre?

    suspend fun getArtistList(query: String): List<Artist>?

    suspend fun getAlbumList(query: String): List<Album>?

    suspend fun getTrackList(query: String): List<Track>?

}
