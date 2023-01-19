package com.example.musicwiki.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentGenreListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenreListFragment : Fragment() {

    private lateinit var binding: FragmentGenreListBinding

    private val viewModel: GenreListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_genre_list, container, false)

        viewModel.genreList.observe(viewLifecycleOwner) {
            it?.let { binding.genre.text = it[0].toString() }
        }
        return binding.root
    }
}
