package com.example.musicwiki.presentation.ui.genre_info_screen.tab_layout_fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.GenreAlbumListItemBinding
import com.example.musicwiki.network.model.Album

class GenreAlbumListAdapter(
    private val clickListener: GenreAlbumClickListener
) : ListAdapter<Album, GenreAlbumListViewHolder>(
    GenreAlbumDiffCallback()
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreAlbumListViewHolder {
        return GenreAlbumListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: GenreAlbumListViewHolder, position: Int) {
        val album = getItem(position)
        holder.bind(album, clickListener)
    }
}

class GenreAlbumListViewHolder constructor(private val binding: GenreAlbumListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: Album,
        clickListener: GenreAlbumClickListener
    ) {
        binding.album = item
        binding.clickListener = clickListener
    }

    companion object {
        fun from(parent: ViewGroup): GenreAlbumListViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = GenreAlbumListItemBinding.inflate(layoutInflater, parent, false)
            return GenreAlbumListViewHolder(binding)
        }
    }
}

class GenreAlbumDiffCallback : DiffUtil.ItemCallback<Album>() {
    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem == newItem
    }
}

class GenreAlbumClickListener(
    val clickListener: (album: Album?) -> Unit,
) {
    fun onClick(album: Album) = clickListener(album)
}

