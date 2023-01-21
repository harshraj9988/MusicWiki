package com.example.musicwiki.presentation.ui.artist_info_screen

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
class ArtistInfoViewModel
@Inject
constructor(
    private val lastFMRepository: LastFMRepository
) : ViewModel() {

    private var artistName: String? = null

    private val _artist = MutableLiveData<Artist?>(null)
    val artist: LiveData<Artist?> = _artist

    private val _topTracks = MutableLiveData<List<Track>?>(null)
    val topTracks: LiveData<List<Track>?> = _topTracks

    private val _topAlbums = MutableLiveData<List<Album>?>(null)
    val topAlbums: LiveData<List<Album>?> = _topAlbums

    private val _topGenres = MutableLiveData<List<Genre>?>(null)
    val topGenres: LiveData<List<Genre>?> = _topGenres

    fun getArtistInfo(artist: String) {
        this.artistName = artist
        fetchArtistInfo()
        fetchArtistTopAlbums()
        fetchArtistTopTracks()
        fetchArtistTopGenres()
    }

    private fun fetchArtistInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            _artist.postValue(lastFMRepository.getArtistInfo(artistName!!))
        }
    }

    private fun fetchArtistTopAlbums() {
        viewModelScope.launch(Dispatchers.IO) {
            _topAlbums.postValue(lastFMRepository.getArtistTopAlbums(artistName!!))
        }
    }

    private fun fetchArtistTopGenres() {
        viewModelScope.launch(Dispatchers.IO) {
            _topGenres.postValue(lastFMRepository.getArtistTopGenres(artistName!!))
        }
    }

    private fun fetchArtistTopTracks() {
        viewModelScope.launch(Dispatchers.IO) {
            _topTracks.postValue(lastFMRepository.getArtistTopTracks(artistName!!))
        }
    }
}
