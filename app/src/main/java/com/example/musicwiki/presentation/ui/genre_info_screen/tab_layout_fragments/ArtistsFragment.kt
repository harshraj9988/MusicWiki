package com.example.musicwiki.presentation.ui.genre_info_screen.tab_layout_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentArtistsBinding
import com.example.musicwiki.presentation.ui.genre_info_screen.GenreInfoFragmentDirections
import com.example.musicwiki.presentation.ui.genre_info_screen.GenreInfoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtistsFragment : Fragment() {

    private lateinit var binding: FragmentArtistsBinding
    private val viewModel: GenreInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_artists, container, false)

        val adapter = ArtistListAdapter (ArtistClickListener {
            it?.let {
                Navigation.findNavController(requireView()).navigate(
                    GenreInfoFragmentDirections.actionGenreInfoFragmentToArtistInfoFragment(it.name)
                )
            }
        })
        binding.artistsRecyclerView.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        binding.artistsRecyclerView.setHasFixedSize(false)
        binding.artistsRecyclerView.adapter = adapter

        viewModel.topArtists.observe(viewLifecycleOwner) {list ->
            list?.let {
                adapter.submitList(it)
                adapter.notifyItemRangeInserted(0, it.size)
            }
        }

        return binding.root
    }

}
