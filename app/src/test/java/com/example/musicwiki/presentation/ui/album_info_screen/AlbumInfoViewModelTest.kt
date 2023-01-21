package com.example.musicwiki.presentation.ui.album_info_screen

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.musicwiki.getOrAwaitValue
import com.example.musicwiki.network.model.*
import com.example.musicwiki.presentation.ui.artist_info_screen.ArtistInfoViewModel
import com.example.musicwiki.repository.LastFMRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class AlbumInfoViewModelTest {
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
    fun test_GetAlbumInfo_expectedTrue() = runTest {
        Mockito.`when`(repository.getAlbumInfo("Cher", "Believe")).thenReturn(AlbumInfo(name = "Believe", artist = "Cher"))

        val sut = AlbumInfoViewModel(repository)
        sut.getAlbumInfo("Cher", "Believe")

        testDispatcher.scheduler.advanceUntilIdle()

        val result = sut.albumInfo.getOrAwaitValue()
        assertEquals(true, result.name == "Believe")
        assertEquals(true, result.artist == "Cher")
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}
