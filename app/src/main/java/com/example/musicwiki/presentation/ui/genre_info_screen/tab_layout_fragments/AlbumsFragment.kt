package com.example.musicwiki.presentation.ui.genre_info_screen.tab_layout_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentAlbumsBinding
import com.example.musicwiki.presentation.ui.genre_info_screen.GenreInfoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumsFragment : Fragment() {

    private lateinit var binding: FragmentAlbumsBinding
    private val viewModel: GenreInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_albums, container, false)

        return binding.root
    }
}
