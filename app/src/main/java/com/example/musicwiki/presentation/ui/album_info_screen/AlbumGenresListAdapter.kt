package com.example.musicwiki.presentation.ui.album_info_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.AlbumGenresListItemBinding
import com.example.musicwiki.databinding.ArtistGenresListItemBinding
import com.example.musicwiki.network.model.Genre
import com.example.musicwiki.presentation.ui.artist_info_screen.tab_layout_fragments.ArtistGenresClickListener
import com.example.musicwiki.presentation.ui.artist_info_screen.tab_layout_fragments.ArtistGenresDiffCallback
import com.example.musicwiki.presentation.ui.artist_info_screen.tab_layout_fragments.ArtistGenresListViewHolder

class AlbumGenresListAdapter(
    private val clickListener: AlbumGenresClickListener
) : ListAdapter<Genre, AlbumGenresListViewHolder>(
    AlbumGenresDiffCallback()
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumGenresListViewHolder {
        return AlbumGenresListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: AlbumGenresListViewHolder, position: Int) {
        val artist = getItem(position)
        holder.bind(artist, clickListener)
    }
}

class AlbumGenresListViewHolder constructor(private val binding: AlbumGenresListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: Genre,
        clickListener: AlbumGenresClickListener
    ) {
        binding.genre = item
        binding.clickListener = clickListener
    }

    companion object {
        fun from(parent: ViewGroup): AlbumGenresListViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = AlbumGenresListItemBinding.inflate(layoutInflater, parent, false)
            return AlbumGenresListViewHolder(binding)
        }
    }
}

class AlbumGenresDiffCallback : DiffUtil.ItemCallback<Genre>() {
    override fun areItemsTheSame(oldItem: Genre, newItem: Genre): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Genre, newItem: Genre): Boolean {
        return oldItem == newItem
    }
}

class AlbumGenresClickListener(
    val clickListener: (genre: Genre?) -> Unit,
) {
    fun onClick(genre: Genre) = clickListener(genre)
}

