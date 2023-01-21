package com.example.musicwiki.repository

import com.example.musicwiki.network.LastFMService
import com.example.musicwiki.network.model.*
import com.example.musicwiki.network.response.*

class LastFMRepositoryImpl(
    private val lastFMService: LastFMService
) : LastFMRepository {

    override suspend fun getGenreList(): List<Genre>? {
        val genreListResponse: GenreListResponse = lastFMService.getGenreListResponse()
        return genreListResponse.topGenres?.genres
    }

    override suspend fun getGenreInfo(genre: String): Genre? {
        return lastFMService.getGenreInfoResponse(genre).genreInfo
    }

    override suspend fun getArtistList(genre: String): List<Artist>? {
        val artistListResponse: ArtistListResponse = lastFMService.getArtistListResponse(genre)
        return artistListResponse.topArtists?.artists
    }

    override suspend fun getAlbumList(genre: String): List<Album>? {
        val albumListResponse: AlbumListResponse = lastFMService.getAlbumListResponse(genre)
        return albumListResponse.topAlbums?.albums
    }

    override suspend fun getTrackList(genre: String): List<Track>? {
        val trackListResponse: TrackListResponse = lastFMService.getTrackListResponse(genre)
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
        val artistTopTracksResponse: ArtistTrackListResponse = lastFMService.getArtistTopTrackListResponse(artist)
        return artistTopTracksResponse.topTracks?.tracks
    }

    override suspend fun getArtistTopAlbums(artist: String): List<Album>? {
        val artistTopAlbumResponse: ArtistAlbumListResponse = lastFMService.getArtistTopAlbumListResponse(artist)
        return artistTopAlbumResponse.topAlbums?.albums
    }

    override suspend fun getAlbumInfo(album: String, artist: String): AlbumInfo? {
        return lastFMService.getAlbumInfoResponse(album, artist).albumInfo
    }
}
