package com.example.musicwiki.presentation.ui.artist_info_screen

import androidx.lifecycle.ViewModel
import com.example.musicwiki.repository.LastFMRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArtistInfoViewModel
@Inject
constructor(
    lastFMRepository: LastFMRepository
) : ViewModel() {

}
