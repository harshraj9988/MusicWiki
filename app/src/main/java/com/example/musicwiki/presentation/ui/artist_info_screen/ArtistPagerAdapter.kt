package com.example.musicwiki.presentation.ui.artist_info_screen

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.musicwiki.presentation.ui.artist_info_screen.tab_layout_fragments.ArtistAlbumsFragment
import com.example.musicwiki.presentation.ui.genre_info_screen.tab_layout_fragments.GenreAlbumsFragment
import com.example.musicwiki.presentation.ui.artist_info_screen.tab_layout_fragments.ArtistGenresFragment
import com.example.musicwiki.presentation.ui.artist_info_screen.tab_layout_fragments.ArtistTracksFragment

class ArtistPagerAdapter(fragment: Fragment, private val viewModel: ArtistInfoViewModel) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> { ArtistAlbumsFragment(viewModel) }
            1 -> { ArtistTracksFragment(viewModel) }
            else -> { ArtistGenresFragment(viewModel) }
        }
    }

    fun getPageTitle(position: Int) : CharSequence {
        return when(position) {
            0 -> "Albums"
            1 -> "Tracks"
            else -> "Genres"
        }
    }
}
