package com.example.musicwiki.presentation.ui.genre_info_screen

import androidx.lifecycle.LiveData
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
class GenreInfoViewModel
@Inject
constructor(
    private val lastFMRepository: LastFMRepository
) : ViewModel() {

    private var genreName: String = ""

    private val _genreInfo = MutableLiveData<Genre?>(null)
    val genreInfo: LiveData<Genre?> = _genreInfo

    private val _topAlbums = MutableLiveData<List<Album>?>(null)
    val topAlbums: LiveData<List<Album>?> = _topAlbums

    private val _topArtists = MutableLiveData<List<Artist>?>(null)
    val topArtists: LiveData<List<Artist>?> = _topArtists

    private val _topTracks = MutableLiveData<List<Track>?>(null)
    val topTracks: LiveData<List<Track>?> = _topTracks

    fun getGenreInfo(genreName: String?) {
        genreName?.let {
            this.genreName = genreName

            fetchGenreInfo()
            fetchGenreTopAlbums()
            fetchGenreTopArtist()
            fetchGenreTopTracks()
        }
    }

    private fun fetchGenreInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            _genreInfo.postValue(lastFMRepository.getGenreInfo(genreName))
        }
    }

    private fun fetchGenreTopAlbums() {
        viewModelScope.launch(Dispatchers.IO) {
            _topAlbums.postValue(lastFMRepository.getAlbumList(genreName))
        }
    }

    private fun fetchGenreTopArtist() {
        viewModelScope.launch(Dispatchers.IO) {
            _topArtists.postValue(lastFMRepository.getArtistList(genreName))
        }
    }

    private fun fetchGenreTopTracks() {
        viewModelScope.launch(Dispatchers.IO) {
            _topTracks.postValue(lastFMRepository.getTrackList(genreName))
        }
    }
}
