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

    private val _albumInfo = MutableLiveData<AlbumInfo>(AlbumInfo())
    val albumInfo: LiveData<AlbumInfo> = _albumInfo
    fun getAlbumInfo(album: String, artist: String) {
        fetchAlbumInfo(album, artist)
    }

    private fun fetchAlbumInfo(album: String, artist: String) {
        viewModelScope.launch(Dispatchers.IO) {
           if(album.isNotEmpty() && artist.isEmpty()){
               _albumInfo.postValue(lastFMRepository.getAlbumInfo(album, artist))
           }
        }
    }
}
