package com.example.musicwiki.presentation.ui.genre_list_screen

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.musicwiki.getOrAwaitValue
import com.example.musicwiki.network.model.Genre
import com.example.musicwiki.repository.LastFMRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GenreListViewModelTest {


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
    fun test_FetchGenreList_emptyListExpected() = runTest {
        Mockito.`when`(repository.getGenreList()).thenReturn(emptyList())

        val sut = GenreListViewModel(repository)
        sut.fetchGenreList()

        testDispatcher.scheduler.advanceUntilIdle()
        val result = sut.genreList.getOrAwaitValue()

        Assert.assertEquals(0, result?.size)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_FetchGenreList_tenItemExpected() = runTest {
        Mockito.`when`(repository.getGenreList()).thenReturn(
            listOf(
                Genre(),
                Genre(),
                Genre(),
                Genre(),
                Genre(),
                Genre(),
                Genre(),
                Genre(),
                Genre(),
                Genre(),
            )
        )

        val sut = GenreListViewModel(repository)
        sut.fetchGenreList()
        testDispatcher.scheduler.advanceUntilIdle()

        val result = sut.genreList.getOrAwaitValue()

        Assert.assertEquals(10, result?.size)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_FetchGenreList_singleItemExpected() = runTest {
        Mockito.`when`(repository.getGenreList()).thenReturn(listOf(Genre()))

        val sut = GenreListViewModel(repository)
        sut.fetchGenreList()
        testDispatcher.scheduler.advanceUntilIdle()

        val result = sut.genreList.getOrAwaitValue()

        Assert.assertEquals(1, result?.size)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}
