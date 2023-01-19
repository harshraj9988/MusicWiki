package com.example.musicwiki.repository

import android.util.Log
import com.example.musicwiki.network.LastFMService
import com.example.musicwiki.network.model.Album
import com.example.musicwiki.network.model.Artist
import com.example.musicwiki.network.model.Genre
import com.example.musicwiki.network.model.Track
import com.example.musicwiki.network.response.AlbumListResponse
import com.example.musicwiki.network.response.ArtistListResponse
import com.example.musicwiki.network.response.GenreListResponse
import com.example.musicwiki.network.response.TrackListResponse

class LastFMRepositoryImpl(
    private val lastFMService: LastFMService
) : LastFMRepository {
    override suspend fun getGenreList(): List<Genre>? {
        val genreListResponse: GenreListResponse = lastFMService.getGenreListResponse()
        Log.e("GenreListResponse", genreListResponse.errorMessage?:"Success" )
        return genreListResponse.topGenres?.genres
    }

    override suspend fun getGenreInfo(query: String): Genre? {
        return lastFMService.getGenreInfoResponse(query).genreInfo
    }

    override suspend fun getArtistList(query: String): List<Artist>? {
        val artistListResponse: ArtistListResponse = lastFMService.getArtistListResponse(query)
        return artistListResponse.topArtists?.artists
    }

    override suspend fun getAlbumList(query: String): List<Album>? {
        val albumListResponse: AlbumListResponse = lastFMService.getAlbumListResponse(query)
        return albumListResponse.topAlbums?.albums
    }

    override suspend fun getTrackList(query: String): List<Track>? {
        val trackListResponse: TrackListResponse = lastFMService.getTrackListResponse(query)
        return trackListResponse.topTracks?.tracks
    }
}
