package com.example.musicwiki.presentation.ui.genre_list_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicwiki.network.model.Genre
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

    private val _genreList = MutableLiveData<List<Genre>?>(null)
    val genreList: LiveData<List<Genre>?> = _genreList

    private val _isExpanded = MutableLiveData<Boolean>(false)
    val isExpanded: LiveData<Boolean> = _isExpanded

    init {
        //TODO: check for internet before calling this
        viewModelScope.launch(Dispatchers.IO) {
            _genreList.postValue(
                lastFMRepository.getGenreList()
            )
        }
    }

    fun changeExpandedState() {
        _isExpanded.value = !(_isExpanded.value)!!
    }
}
