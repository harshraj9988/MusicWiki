package com.example.musicwiki.presentation.ui.genre_info_screen

import androidx.lifecycle.ViewModel
import com.example.musicwiki.repository.LastFMRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GenreInfoViewModel
@Inject
constructor(
    lastFMRepository: LastFMRepository
) : ViewModel() {

}
