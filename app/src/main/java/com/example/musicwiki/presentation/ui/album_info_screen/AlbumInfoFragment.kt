package com.example.musicwiki.presentation.ui.album_info_screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentAlbumInfoBinding
import com.example.musicwiki.presentation.ui.artist_info_screen.tab_layout_fragments.ArtistGenresClickListener
import com.example.musicwiki.presentation.ui.artist_info_screen.tab_layout_fragments.ArtistGenresListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumInfoFragment : Fragment() {

    private lateinit var args: AlbumInfoFragmentArgs
    private lateinit var binding: FragmentAlbumInfoBinding
    private val viewModel: AlbumInfoViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_album_info, container, false)

        args = AlbumInfoFragmentArgs.fromBundle(requireArguments())
        if (args.album != null && args.artist != null) {
            viewModel.getAlbumInfo(args.album!!, args.artist!!)
        } else {
            Toast.makeText(context, "Error! Please try again", Toast.LENGTH_SHORT).show()
        }

        val adapter = ArtistGenresListAdapter(ArtistGenresClickListener {
            it?.let {
                Navigation.findNavController(requireView()).navigate(
                    AlbumInfoFragmentDirections.actionAlbumInfoFragmentToGenreInfoFragment(it.name)
                )
            }
        })

        binding.albumInfoGenreRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        binding.albumInfoGenreRecyclerView.setHasFixedSize(false)
        binding.albumInfoGenreRecyclerView.adapter = adapter

        viewModel.albumInfo.observe(viewLifecycleOwner) {
            it?.let { albumInfo ->
                albumInfo.genreList?.let { genreList ->
                    genreList.genres?.let { genres ->
                        if (adapter.itemCount > 0) {
                            adapter.submitList(genres)
                            adapter.notifyItemRangeChanged(0, genres.size)
                        } else {
                            adapter.submitList(genres)
                            adapter.notifyItemRangeInserted(0, genres.size)
                        }
                    }
                }
                binding.albumInfo = albumInfo
                binding.invalidateAll()
            }
        }



        return binding.root
    }

}
