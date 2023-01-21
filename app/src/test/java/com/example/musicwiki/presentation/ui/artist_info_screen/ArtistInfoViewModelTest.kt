package com.example.musicwiki.presentation.ui.artist_info_screen

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.musicwiki.getOrAwaitValue
import com.example.musicwiki.network.model.Album
import com.example.musicwiki.network.model.Artist
import com.example.musicwiki.network.model.Genre
import com.example.musicwiki.network.model.Track
import com.example.musicwiki.repository.LastFMRepository
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

class ArtistInfoViewModelTest{

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: LastFMRepository

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_FetchArtist_expectedTrue() = runTest {
        Mockito.`when`(repository.getArtistInfo("Cher")).thenReturn(Artist(name = "Cher"))

        val sut = ArtistInfoViewModel(repository)
        sut.getArtistInfo("Cher")

        testDispatcher.scheduler.advanceUntilIdle()

        val result = sut.artist.getOrAwaitValue()
        assertEquals(true, result.name == "Cher")
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_ArtistTopTracks_expectedSizeFive() = runTest {
        Mockito.`when`(repository.getArtistTopTracks("Cher")).thenReturn(listOf(
            Track(),
            Track(),
            Track(),
            Track(),
            Track(),
        ))

        val sut = ArtistInfoViewModel(repository)
        sut.getArtistInfo("Cher")

        testDispatcher.scheduler.advanceUntilIdle()

        val result = sut.topTracks.getOrAwaitValue()
        assertEquals(5, result.size)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_ArtistTopAlbums_expectedSizeThree() = runTest {
        Mockito.`when`(repository.getArtistTopAlbums("Cher")).thenReturn(listOf(
            Album(),
            Album(),
            Album(),
        ))

        val sut = ArtistInfoViewModel(repository)
        sut.getArtistInfo("Cher")

        testDispatcher.scheduler.advanceUntilIdle()

        val result = sut.topAlbums.getOrAwaitValue()
        assertEquals(3, result.size)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_ArtistTopGenre_expectedSizeFive() = runTest {
        Mockito.`when`(repository.getArtistTopGenres("Cher")).thenReturn(listOf(
            Genre(),
            Genre(),
        ))

        val sut = ArtistInfoViewModel(repository)
        sut.getArtistInfo("Cher")

        testDispatcher.scheduler.advanceUntilIdle()

        val result = sut.topGenres.getOrAwaitValue()
        assertEquals(2, result.size)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}
