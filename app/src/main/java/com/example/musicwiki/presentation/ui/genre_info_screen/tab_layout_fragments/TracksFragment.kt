package com.example.musicwiki.presentation.ui.genre_info_screen.tab_layout_fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentTracksBinding
import com.example.musicwiki.presentation.ui.genre_info_screen.GenreInfoViewModel
import com.example.musicwiki.presentation.ui.genre_list_screen.GenreClickListener
import com.example.musicwiki.presentation.ui.genre_list_screen.GenreListAdapter
import com.example.musicwiki.presentation.ui.genre_list_screen.GenreListFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TracksFragment(
    private val viewModel: GenreInfoViewModel

) : Fragment() {

    private lateinit var binding: FragmentTracksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_tracks, container, false)

        val adapter = TrackListAdapter (TrackClickListener{})
        binding.tracksRecyclerView.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        binding.tracksRecyclerView.setHasFixedSize(false)
        binding.tracksRecyclerView.adapter = adapter

        viewModel.topTracks.observe(viewLifecycleOwner) {list ->
            list?.let {
                if(adapter.itemCount == 0){
                    adapter.submitList(it)
                    adapter.notifyItemRangeInserted(0, it.size)
                }else{
                    adapter.submitList(it)
                    adapter.notifyItemRangeChanged(0, it.size)
                }
            }
        }

        return binding.root
    }

}
