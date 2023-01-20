package com.example.musicwiki.presentation.ui.album_info_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentAlbumInfoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumInfoFragment : Fragment() {

    private lateinit var binding: FragmentAlbumInfoBinding
    private val viewModel: AlbumInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_album_info, container, false)

        return binding.root
    }

}
