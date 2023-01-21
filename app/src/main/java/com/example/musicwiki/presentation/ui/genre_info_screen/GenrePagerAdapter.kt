package com.example.musicwiki.presentation.ui.genre_info_screen

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.musicwiki.presentation.ui.genre_info_screen.tab_layout_fragments.GenreAlbumsFragment
import com.example.musicwiki.presentation.ui.genre_info_screen.tab_layout_fragments.GenreArtistsFragment
import com.example.musicwiki.presentation.ui.genre_info_screen.tab_layout_fragments.GenreTracksFragment

class GenrePagerAdapter(fragment: Fragment, private val viewModel: GenreInfoViewModel) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> { GenreAlbumsFragment(viewModel) }
            1 -> { GenreArtistsFragment(viewModel) }
            else -> { GenreTracksFragment(viewModel) }
        }
    }

    fun getPageTitle(position: Int) : CharSequence {
        return when(position) {
            0 -> "Albums"
            1 -> "Artists"
            else -> "Tracks"
        }
    }
}
