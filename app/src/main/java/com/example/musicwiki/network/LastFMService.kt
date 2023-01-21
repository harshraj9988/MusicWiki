package com.example.musicwiki.network

import com.example.musicwiki.network.response.*
import com.example.musicwiki.network.utils.API_KEY
import com.example.musicwiki.network.utils.END_POINT
import com.example.musicwiki.network.utils.USER_AGENT
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LastFMService {
    @GET(END_POINT)
    suspend fun getGenreListResponse(
        @Header("user-agent") userAgent: String = USER_AGENT,
        @Query("method") method: String = "tag.getTopTags",
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = "json"
    ): GenreListResponse

    @GET(END_POINT)
    suspend fun getGenreInfoResponse(
        @Query("tag") genre: String,
        @Header("user-agent") userAgent: String = USER_AGENT,
        @Query("method") method: String = "tag.getinfo",
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = "json"
    ): GenreInfoResponse

    @GET(END_POINT)
    suspend fun getAlbumListResponse(
        @Query("tag") genre: String,
        @Header("user-agent") userAgent: String = USER_AGENT,
        @Query("method") method: String = "tag.gettopalbums",
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = "json"
    ): AlbumListResponse

    @GET(END_POINT)
    suspend fun getArtistListResponse(
        @Query("tag") genre: String,
        @Header("user-agent") userAgent: String = USER_AGENT,
        @Query("method") method: String = "tag.gettopartists",
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = "json"
    ): ArtistListResponse

    @GET(END_POINT)
    suspend fun getTrackListResponse(
        @Query("tag") genre: String,
        @Header("user-agent") userAgent: String = USER_AGENT,
        @Query("method") method: String = "tag.gettoptracks",
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = "json"
    ): TrackListResponse

    @GET(END_POINT)
    suspend fun getArtistInfoResponse(
        @Query("artist") artist: String,
        @Header("user-agent") userAgent: String = USER_AGENT,
        @Query("method") method: String = "artist.getinfo",
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = "json"
    ): ArtistInfoResponse

    @GET(END_POINT)
    suspend fun getArtistTopTrackListResponse(
        @Query("artist") genre: String,
        @Header("user-agent") userAgent: String = USER_AGENT,
        @Query("method") method: String = "artist.gettoptracks",
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = "json"
    ): ArtistTrackListResponse

    @GET(END_POINT)
    suspend fun getArtistTopGenreListResponse(
        @Query("artist") artist: String,
        @Header("user-agent") userAgent: String = USER_AGENT,
        @Query("method") method: String = "artist.gettoptags",
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = "json"
    ): GenreListResponse

    @GET(END_POINT)
    suspend fun getArtistTopAlbumListResponse(
        @Query("artist") artist: String,
        @Header("user-agent") userAgent: String = USER_AGENT,
        @Query("method") method: String = "artist.gettopalbums",
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = "json"
    ): ArtistAlbumListResponse

    @GET(END_POINT)
    suspend fun getAlbumInfoResponse(
        @Query("album") album: String,
        @Query("artist") artist: String,
        @Header("user-agent") userAgent: String = USER_AGENT,
        @Query("method") method: String = "album.getinfo",
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = "json"
    ): AlbumInfoResponse
}
