package com.example.musicwiki.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.musicwiki.network.LastFMService
import com.example.musicwiki.network.model.*
import com.example.musicwiki.network.response.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class LastFMRepositoryImplTest {


    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var service: LastFMService

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_GetGenreList_expectingEmptyGenreList() = runTest {
        Mockito.`when`(service.getGenreListResponse())
            .thenReturn(GenreListResponse(errorMessage = "Error", errorCount = 400))

        val sut = LastFMRepositoryImpl(service)
        val result = sut.getGenreList()

        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(0, result?.size)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_GetGenreInfo_expectingTrue() = runTest {
        Mockito.`when`(service.getGenreInfoResponse("Rock"))
            .thenReturn(GenreInfoResponse(Genre(name = "Rock")))

        val sut = LastFMRepositoryImpl(service)
        val result = sut.getGenreInfo("Rock")

        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals("Rock", result?.name)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_GetArtistList_expectingTrue() = runTest {
        Mockito.`when`(service.getArtistListResponse("Indie")).thenReturn(
            ArtistListResponse(
                TopArtists(listOf(Artist(), Artist(), Artist()))
            )
        )

        val sut = LastFMRepositoryImpl(service)
        val result = sut.getArtistList("Indie")
        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(3, result?.size)
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_GetAlbumList_expectingTrue() = runTest {
        Mockito.`when`(service.getAlbumListResponse("Rock")).thenReturn(
            AlbumListResponse(
                TopAlbums(
                    listOf(Album(), Album())
                )
            )
        )

        val sut = LastFMRepositoryImpl(service)
        val result = sut.getAlbumList("Rock")
        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(2, result?.size)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_GetTrackList() = runTest {
        Mockito.`when`(service.getTrackListResponse("Rock")).thenReturn(
            TrackListResponse(
                TopTracks(
                    listOf(Track(), Track(), Track())
                )
            )
        )

        val sut = LastFMRepositoryImpl(service)
        val result =
            sut.getTrackList("Rock")
        testDispatcher.scheduler.advanceUntilIdle()
        assertEquals(3, result?.size)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_GetArtistInfo() = runTest {
        Mockito.`when`(service.getArtistInfoResponse("Jake"))
            .thenReturn(ArtistInfoResponse(Artist(name = "Jake")))

        val sut = LastFMRepositoryImpl(service)
        val result =
            sut.getArtistInfo("Jake")
        testDispatcher.scheduler.advanceUntilIdle()
        assertEquals(true, result?.name == "Jake")
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_GetArtistTopGenres() = runTest {
        Mockito.`when`(service.getArtistTopGenreListResponse("Roy")).thenReturn(
            GenreListResponse(
                TopGenres(genres = listOf(Genre(), Genre()))
            )
        )

        val sut = LastFMRepositoryImpl(service)
        val result =
            sut.getArtistTopGenres("Roy")
        testDispatcher.scheduler.advanceUntilIdle()
        assertEquals(2, result?.size)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_GetArtistTopTracks() = runTest {
        Mockito.`when`(service.getArtistTopTrackListResponse("Kate")).thenReturn(
            ArtistTrackListResponse(TopTracks(listOf(Track(), Track())))
        )

        val sut = LastFMRepositoryImpl(service)
        val result =
        sut.getArtistTopTracks("Kate")
        testDispatcher.scheduler.advanceUntilIdle()
        assertEquals(2, result?.size)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_GetArtistTopAlbums() = runTest {
        Mockito.`when`(service.getArtistTopAlbumListResponse("Cher")).thenReturn(
            ArtistAlbumListResponse(
                TopAlbums(listOf(Album(), Album()))
            )
        )

        val sut = LastFMRepositoryImpl(service)
        val result =
            sut.getArtistTopAlbums("Cher")
        testDispatcher.scheduler.advanceUntilIdle()
        assertEquals(2, result?.size)
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_GetAlbumInfo() = runTest {
        Mockito.`when`(service.getAlbumInfoResponse("Divide", "Ed")).thenReturn(
            AlbumInfoResponse(
                AlbumInfo(name = "Divide", artist = "Ed")
            )
        )

        val sut = LastFMRepositoryImpl(service)
        val result = sut.getAlbumInfo("Divide", "Ed")
        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(true, result?.name == "Divide")
        assertEquals(true, result?.artist == "Ed")
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

}
