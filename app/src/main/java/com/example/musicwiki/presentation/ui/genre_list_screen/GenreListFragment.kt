package com.example.musicwiki.presentation.ui.genre_list_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

        val list = viewModel.list

        val adapter = GenreListAdapter()
        adapter.submitList(viewModel.list)

        binding.genreListRecyclerView.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        binding.genreListRecyclerView.setHasFixedSize(true)
        binding.genreListRecyclerView.adapter = adapter


        return binding.root
    }
}
