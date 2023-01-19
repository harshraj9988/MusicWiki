package com.example.musicwiki.presentation.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicwiki.network.model.Album
import com.example.musicwiki.network.model.Artist
import com.example.musicwiki.network.model.Genre
import com.example.musicwiki.network.model.Track
import com.example.musicwiki.repository.LastFMRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenreListViewModel
@Inject
constructor(
    private val lastFMRepository: LastFMRepository
) : ViewModel() {

    val genreList = MutableLiveData<List<Genre>?>(null)
    val genreInfo = MutableLiveData<Genre?>(null)
    val albumList = MutableLiveData<List<Album>?>(null)
    val artistList = MutableLiveData<List<Artist>?>(null)
    val trackList = MutableLiveData<List<Track>?>(null)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            genreList.postValue( lastFMRepository.getGenreList() )
            genreInfo.postValue(lastFMRepository.getGenreInfo("rock"))
            albumList.postValue(lastFMRepository.getAlbumList("rock"))
            artistList.postValue(lastFMRepository.getArtistList("rock"))
            trackList.postValue(lastFMRepository.getTrackList("rock"))
        }
    }

}
