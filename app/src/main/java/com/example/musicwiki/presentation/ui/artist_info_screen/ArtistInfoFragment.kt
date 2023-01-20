package com.example.musicwiki.presentation.ui.artist_info_screen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentArtistInfoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtistInfoFragment : Fragment() {

    private lateinit var binding: FragmentArtistInfoBinding
    private val viewModel: ArtistInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_artist_info, container, false)

        return binding.root
    }
}
