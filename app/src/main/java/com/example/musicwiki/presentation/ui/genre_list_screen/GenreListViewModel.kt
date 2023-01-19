package com.example.musicwiki.presentation.ui.genre_list_screen

import androidx.lifecycle.ViewModel
import com.example.musicwiki.network.model.Genre
import com.example.musicwiki.repository.LastFMRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GenreListViewModel
@Inject
constructor(
    private val lastFMRepository: LastFMRepository
) : ViewModel() {

    val list = listOf(
        Genre(name = "Rock"),
        Genre(name = "Jazz"),
        Genre(name = "Metal"),
        Genre(name = "Sufi"),
        Genre(name = "Hip Hop"),
        Genre(name = "Rap"),
        Genre(name = "Electric")
    )
}
