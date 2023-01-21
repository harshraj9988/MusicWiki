package com.example.musicwiki.presentation.ui.genre_info_screen.tab_layout_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentTabLayoutRecyclerViewBinding
import com.example.musicwiki.presentation.ui.genre_info_screen.GenreInfoFragmentDirections
import com.example.musicwiki.presentation.ui.genre_info_screen.GenreInfoViewModel

//@AndroidEntryPoint
class GenreAlbumsFragment(
    private val viewModel: GenreInfoViewModel
) : Fragment() {

    private lateinit var binding: FragmentTabLayoutRecyclerViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_tab_layout_recycler_view, container, false)

        val adapter = GenreAlbumListAdapter (GenreAlbumClickListener {
            it?.let {
                Navigation.findNavController(requireView()).navigate(
                    GenreInfoFragmentDirections.actionGenreInfoFragmentToAlbumInfoFragment(it.name, it.artist?.name)
                )
            }
        })
        binding.recyclerView.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        binding.recyclerView.setHasFixedSize(false)
        binding.recyclerView.adapter = adapter

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
