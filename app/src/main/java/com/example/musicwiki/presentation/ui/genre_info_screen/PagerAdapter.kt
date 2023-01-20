package com.example.musicwiki.presentation.ui.genre_info_screen

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.musicwiki.presentation.ui.genre_info_screen.tab_layout_fragments.AlbumsFragment
import com.example.musicwiki.presentation.ui.genre_info_screen.tab_layout_fragments.ArtistsFragment
import com.example.musicwiki.presentation.ui.genre_info_screen.tab_layout_fragments.TracksFragment

class PagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> { AlbumsFragment() }
            1 -> { ArtistsFragment() }
            else -> { TracksFragment() }
        }
    }

    fun getPageTitle(position: Int) : String {
        return when(position) {
            0 -> "Albums"
            1 -> "Artists"
            else -> "Tracks"
        }
    }
}
