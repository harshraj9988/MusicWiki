package com.example.musicwiki.repository

import com.example.musicwiki.network.LastFMService
import com.example.musicwiki.network.model.*
import com.example.musicwiki.network.response.AlbumListResponse
import com.example.musicwiki.network.response.ArtistListResponse
import com.example.musicwiki.network.response.GenreListResponse
import com.example.musicwiki.network.response.TrackListResponse

class LastFMRepositoryImpl(
    private val lastFMService: LastFMService
) : LastFMRepository {
    override suspend fun getGenreList(): List<Genre>? {
        val genreListResponse: GenreListResponse = lastFMService.getGenreListResponse()
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

    override suspend fun getArtistInfo(artist: String): Artist? {
        return lastFMService.getArtistInfoResponse(artist).artistInfo
    }

    override suspend fun getArtistTopGenres(artist: String): List<Genre>? {
        val artistTopGenresResponse: GenreListResponse = lastFMService.getArtistTopGenreListResponse(artist)
        return artistTopGenresResponse.topGenres?.genres
    }

    override suspend fun getArtistTopTracks(artist: String): List<Track>? {
        val artistTopTracksResponse: TrackListResponse = lastFMService.getArtistTopTrackListResponse(artist)
        return artistTopTracksResponse.topTracks?.tracks
    }

    override suspend fun getArtistTopAlbums(artist: String): List<Album>? {
        val artistTopAlbumResponse: AlbumListResponse = lastFMService.getArtistTopAlbumListResponse(artist)
        return artistTopAlbumResponse.topAlbums?.albums
    }

    override suspend fun getAlbumInfo(album: String, artist: String): AlbumInfo? {
        return lastFMService.getAlbumInfoResponse(album, artist).albumInfo
    }
}
