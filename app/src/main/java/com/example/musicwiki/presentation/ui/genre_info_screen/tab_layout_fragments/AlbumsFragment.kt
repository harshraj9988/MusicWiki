package com.example.musicwiki.presentation.ui.genre_info_screen.tab_layout_fragments

import android.os.Bundle
import android.util.Log
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
import com.example.musicwiki.databinding.FragmentAlbumsBinding
import com.example.musicwiki.databinding.FragmentGenreInfoBinding
import com.example.musicwiki.presentation.ui.genre_info_screen.GenreInfoFragmentDirections
import com.example.musicwiki.presentation.ui.genre_info_screen.GenreInfoViewModel
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class AlbumsFragment(
    private val viewModel: GenreInfoViewModel
) : Fragment() {

    private lateinit var binding: FragmentAlbumsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_albums, container, false)

        val adapter = AlbumListAdapter (AlbumClickListener {
            it?.let {
                Navigation.findNavController(requireView()).navigate(
                    GenreInfoFragmentDirections.actionGenreInfoFragmentToAlbumInfoFragment(it.name, it.artist?.name)
                )
            }
        })
        binding.albumsRecyclerView.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        binding.albumsRecyclerView.setHasFixedSize(false)
        binding.albumsRecyclerView.adapter = adapter

        viewModel.topAlbums.observe(viewLifecycleOwner) {list ->
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
