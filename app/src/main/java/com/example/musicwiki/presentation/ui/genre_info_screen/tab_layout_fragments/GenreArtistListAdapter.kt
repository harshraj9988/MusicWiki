package com.example.musicwiki.presentation.ui.genre_info_screen.tab_layout_fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.GenreArtistListItemBinding
import com.example.musicwiki.network.model.Artist

class GenreArtistListAdapter(
    private val clickListener: GenreArtistClickListener
) : ListAdapter<Artist, GenreArtistListViewHolder>(
    GenreArtistDiffCallback()
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreArtistListViewHolder {
        return GenreArtistListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: GenreArtistListViewHolder, position: Int) {
        val artist = getItem(position)
        holder.bind(artist, clickListener)
    }
}

class GenreArtistListViewHolder constructor(private val binding: GenreArtistListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: Artist,
        clickListener: GenreArtistClickListener
    ) {
        binding.artist = item
        binding.clickListener = clickListener
    }

    companion object {
        fun from(parent: ViewGroup): GenreArtistListViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = GenreArtistListItemBinding.inflate(layoutInflater, parent, false)
            return GenreArtistListViewHolder(binding)
        }
    }
}

class GenreArtistDiffCallback : DiffUtil.ItemCallback<Artist>() {
    override fun areItemsTheSame(oldItem: Artist, newItem: Artist): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Artist, newItem: Artist): Boolean {
        return oldItem == newItem
    }
}

class GenreArtistClickListener(
    val clickListener: (artist: Artist?) -> Unit,
) {
    fun onClick(artist: Artist) = clickListener(artist)
}

