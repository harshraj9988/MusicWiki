package com.example.musicwiki.presentation.ui.genre_info_screen

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.musicwiki.getOrAwaitValue
import com.example.musicwiki.network.model.Genre
import com.example.musicwiki.presentation.ui.genre_list_screen.GenreListViewModel
import com.example.musicwiki.repository.LastFMRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GenreInfoViewModelTest {

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
    fun test_FetchGenreInfo_expectedTrue() = runTest {
        Mockito.`when`(repository.getGenreInfo("Rock")).thenReturn(Genre(name = "Rock"))

        val sut = GenreInfoViewModel(repository)
        sut.getGenreInfo("Rock")

        testDispatcher.scheduler.advanceUntilIdle()

        val result = sut.genreInfo.getOrAwaitValue()
        assertEquals(true, result?.name == "Rock")
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}
