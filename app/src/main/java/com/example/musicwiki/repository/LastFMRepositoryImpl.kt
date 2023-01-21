package com.example.musicwiki.repository

import com.example.musicwiki.network.LastFMService
import com.example.musicwiki.network.model.*
import com.example.musicwiki.network.response.*

class LastFMRepositoryImpl(
    private val lastFMService: LastFMService
) : LastFMRepository {

    override suspend fun getGenreList(): List<Genre> {
        val genreListResponse: GenreListResponse = lastFMService.getGenreListResponse()
        return genreListResponse.topGenres?.genres ?: emptyList()
    }

    override suspend fun getGenreInfo(genre: String): Genre {
        return lastFMService.getGenreInfoResponse(genre).genreInfo ?: Genre()
    }

    override suspend fun getArtistList(genre: String): List<Artist> {
        val artistListResponse: ArtistListResponse = lastFMService.getArtistListResponse(genre)
        return artistListResponse.topArtists?.artists ?: emptyList()
    }

    override suspend fun getAlbumList(genre: String): List<Album> {
        val albumListResponse: AlbumListResponse = lastFMService.getAlbumListResponse(genre)
        return albumListResponse.topAlbums?.albums ?: emptyList()
    }

    override suspend fun getTrackList(genre: String): List<Track> {
        val trackListResponse: TrackListResponse = lastFMService.getTrackListResponse(genre)
        return trackListResponse.topTracks?.tracks ?: emptyList()
    }

    override suspend fun getArtistInfo(artist: String): Artist {
        return lastFMService.getArtistInfoResponse(artist).artistInfo ?: Artist()
    }

    override suspend fun getArtistTopGenres(artist: String): List<Genre> {
        val artistTopGenresResponse: GenreListResponse = lastFMService.getArtistTopGenreListResponse(artist)
        return artistTopGenresResponse.topGenres?.genres ?: emptyList()
    }

    override suspend fun getArtistTopTracks(artist: String): List<Track> {
        val artistTopTracksResponse: ArtistTrackListResponse = lastFMService.getArtistTopTrackListResponse(artist)
        return artistTopTracksResponse.topTracks?.tracks ?: emptyList()
    }

    override suspend fun getArtistTopAlbums(artist: String): List<Album> {
        val artistTopAlbumResponse: ArtistAlbumListResponse = lastFMService.getArtistTopAlbumListResponse(artist)
        return artistTopAlbumResponse.topAlbums?.albums ?: emptyList()
    }

    override suspend fun getAlbumInfo(album: String, artist: String): AlbumInfo {
        return lastFMService.getAlbumInfoResponse(album, artist).albumInfo ?: AlbumInfo()
    }
}
