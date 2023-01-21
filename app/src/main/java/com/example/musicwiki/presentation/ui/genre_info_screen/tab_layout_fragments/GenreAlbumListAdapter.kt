package com.example.musicwiki.presentation.ui.genre_info_screen.tab_layout_fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.AlbumListItemBinding
import com.example.musicwiki.network.model.Album

class AlbumListAdapter(
    private val clickListener: AlbumClickListener
) : ListAdapter<Album, AlbumListViewHolder>(
    AlbumDiffCallback()
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumListViewHolder {
        return AlbumListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: AlbumListViewHolder, position: Int) {
        val album = getItem(position)
        holder.bind(album, clickListener)
    }
}

class AlbumListViewHolder constructor(private val binding: AlbumListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: Album,
        clickListener: AlbumClickListener
    ) {
        binding.album = item
        binding.clickListener = clickListener
    }

    companion object {
        fun from(parent: ViewGroup): AlbumListViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = AlbumListItemBinding.inflate(layoutInflater, parent, false)
            return AlbumListViewHolder(binding)
        }
    }
}

class AlbumDiffCallback : DiffUtil.ItemCallback<Album>() {
    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem == newItem
    }
}

class AlbumClickListener(
    val clickListener: (album: Album?) -> Unit,
) {
    fun onClick(album: Album) = clickListener(album)
}

