package com.example.musicwiki.presentation.ui.artist_info_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentArtistInfoBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtistInfoFragment : Fragment() {

    private lateinit var args: ArtistInfoFragmentArgs
    private lateinit var binding: FragmentArtistInfoBinding
    private val viewModel: ArtistInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_artist_info, container, false)

        args = ArtistInfoFragmentArgs.fromBundle(requireArguments())

        if (args.artist != null) {
            viewModel.getArtistInfo(args.artist!!)
        } else {
            Toast.makeText(context, "Error! Please try again", Toast.LENGTH_SHORT).show()
        }

        val artistPagerAdapter = ArtistPagerAdapter(this, viewModel)
        binding.viewPager.adapter = artistPagerAdapter

        TabLayoutMediator( binding.tabLayout, binding.viewPager ) { tab, position ->
            tab.text = artistPagerAdapter.getPageTitle(position)
        }.attach()

        viewModel.artist.observe(viewLifecycleOwner) { artist ->
            artist?.let {
                binding.artist = it
            }
        }

        return binding.root
    }
}
