package com.example.musicwiki.presentation.ui.genre_info_screen.tab_layout_fragments

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.ArtistListItemBinding
import com.example.musicwiki.network.model.Artist

class ArtistListAdapter(
    private val clickListener: ArtistClickListener
) : ListAdapter<Artist, ArtistListViewHolder>(
    ArtistDiffCallback()
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistListViewHolder {
        return ArtistListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ArtistListViewHolder, position: Int) {
        val artist = getItem(position)
        holder.bind(artist, clickListener)
    }
}

class ArtistListViewHolder constructor(private val binding: ArtistListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: Artist,
        clickListener: ArtistClickListener
    ) {
        binding.artist = item
        binding.clickListener = clickListener
        Log.d("bind", item.toString())
    }

    companion object {
        fun from(parent: ViewGroup): ArtistListViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ArtistListItemBinding.inflate(layoutInflater, parent, false)
            return ArtistListViewHolder(binding)
        }
    }
}

class ArtistDiffCallback : DiffUtil.ItemCallback<Artist>() {
    override fun areItemsTheSame(oldItem: Artist, newItem: Artist): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Artist, newItem: Artist): Boolean {
        return oldItem == newItem
    }
}

class ArtistClickListener(
    val clickListener: (artist: Artist?) -> Unit,
) {
    fun onClick(artist: Artist) = clickListener(artist)
}

