package com.example.musicwiki.repository

import com.example.musicwiki.network.model.*

interface LastFMRepository {

    suspend fun getGenreList(): List<Genre>?

    suspend fun getGenreInfo(query: String): Genre?

    suspend fun getArtistList(query: String): List<Artist>?

    suspend fun getAlbumList(query: String): List<Album>?

    suspend fun getTrackList(query: String): List<Track>?

    suspend fun getArtistInfo(artist: String): Artist?

    suspend fun getArtistTopGenres(artist: String): List<Genre>?

    suspend fun getArtistTopTracks(artist: String): List<Track>?

    suspend fun getArtistTopAlbums(artist: String): List<Album>?

    suspend fun getAlbumInfo(album: String, artist: String): AlbumInfo?

}
