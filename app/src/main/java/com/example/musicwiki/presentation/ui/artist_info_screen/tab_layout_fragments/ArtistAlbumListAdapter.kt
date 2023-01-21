package com.example.musicwiki.presentation.ui.artist_info_screen.tab_layout_fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.ArtistAlbumListItemBinding
import com.example.musicwiki.network.model.Album

class ArtistAlbumListAdapter(
    private val clickListener: ArtistAlbumClickListener
) : ListAdapter<Album, ArtistAlbumListViewHolder>(
    ArtistAlbumDiffCallback()
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistAlbumListViewHolder {
        return ArtistAlbumListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ArtistAlbumListViewHolder, position: Int) {
        val album = getItem(position)
        holder.bind(album, clickListener)
    }
}

class ArtistAlbumListViewHolder constructor(private val binding: ArtistAlbumListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: Album,
        clickListener: ArtistAlbumClickListener
    ) {
        binding.album = item
        binding.clickListener = clickListener
    }

    companion object {
        fun from(parent: ViewGroup): ArtistAlbumListViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ArtistAlbumListItemBinding.inflate(layoutInflater, parent, false)
            return ArtistAlbumListViewHolder(binding)
        }
    }
}

class ArtistAlbumDiffCallback : DiffUtil.ItemCallback<Album>() {
    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem == newItem
    }
}

class ArtistAlbumClickListener(
    val clickListener: (album: Album?) -> Unit,
) {
    fun onClick(album: Album) = clickListener(album)
}

