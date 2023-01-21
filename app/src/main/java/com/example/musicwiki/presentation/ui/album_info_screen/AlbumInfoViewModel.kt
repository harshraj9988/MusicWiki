package com.example.musicwiki.presentation.ui.album_info_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicwiki.network.model.AlbumInfo
import com.example.musicwiki.repository.LastFMRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumInfoViewModel
@Inject
constructor(
   private val lastFMRepository: LastFMRepository
) : ViewModel() {
    private var album: String? = null
    private var artist: String? = null

    private val _albumInfo = MutableLiveData<AlbumInfo?>(null)
    val albumInfo: LiveData<AlbumInfo?> = _albumInfo
    fun getAlbumInfo(album: String, artist: String) {
        this.album = album
        this.artist = artist
        fetchAlbumInfo()
    }

    private fun fetchAlbumInfo() {
        viewModelScope.launch(Dispatchers.IO) {
           if(album!=null && artist!=null){
               _albumInfo.postValue(lastFMRepository.getAlbumInfo(album!!, artist!!))
           }
        }
    }
}
