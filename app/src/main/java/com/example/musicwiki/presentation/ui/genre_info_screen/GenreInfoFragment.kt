package com.example.musicwiki.presentation.ui.genre_info_screen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentGenreInfoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenreInfoFragment : Fragment() {

    private lateinit var binding: FragmentGenreInfoBinding
    private val viewModel: GenreInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_genre_info, container, false)


        return binding.root
    }



}
