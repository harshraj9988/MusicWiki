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

    private val _artist = MutableLiveData<Artist>(Artist())
    val artist: LiveData<Artist> = _artist

    private val _topTracks = MutableLiveData<List<Track>>(emptyList())
    val topTracks: LiveData<List<Track>> = _topTracks

    private val _topAlbums = MutableLiveData<List<Album>>(emptyList())
    val topAlbums: LiveData<List<Album>> = _topAlbums

    private val _topGenres = MutableLiveData<List<Genre>>(emptyList())
    val topGenres: LiveData<List<Genre>> = _topGenres

    fun getArtistInfo(artist: String) {
        fetchArtistInfo(artist)
        fetchArtistTopAlbums(artist)
        fetchArtistTopTracks(artist)
        fetchArtistTopGenres(artist)
    }

    private fun fetchArtistInfo(artist: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _artist.postValue(lastFMRepository.getArtistInfo(artist))
        }
    }

    private fun fetchArtistTopAlbums(artist: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _topAlbums.postValue(lastFMRepository.getArtistTopAlbums(artist))
        }
    }

    private fun fetchArtistTopGenres(artist: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _topGenres.postValue(lastFMRepository.getArtistTopGenres(artist))
        }
    }

    private fun fetchArtistTopTracks(artist: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _topTracks.postValue(lastFMRepository.getArtistTopTracks(artist))
        }
    }
}
