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
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentAlbumInfoBinding
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

        viewModel.albumInfo.observe(viewLifecycleOwner){
            it?.let {
                Log.d("AlbumInfoFragment", it.toString())
                binding.albumInfo = it
                binding.invalidateAll()
            }
        }

        //TODO: implement horizontal recycler view for genres

        return binding.root
    }

}
