package com.example.musicwiki.presentation.ui.artist_info_screen.tab_layout_fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.ArtistGenresListItemBinding
import com.example.musicwiki.network.model.Genre

class ArtistGenresListAdapter(
    private val clickListener: ArtistGenresClickListener
) : ListAdapter<Genre, ArtistGenresListViewHolder>(
    ArtistGenresDiffCallback()
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistGenresListViewHolder {
        return ArtistGenresListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ArtistGenresListViewHolder, position: Int) {
        val artist = getItem(position)
        holder.bind(artist, clickListener)
    }


}

class ArtistGenresListViewHolder constructor(private val binding: ArtistGenresListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: Genre,
        clickListener: ArtistGenresClickListener
    ) {
        binding.genre = item
        binding.clickListener = clickListener
    }

    companion object {
        fun from(parent: ViewGroup): ArtistGenresListViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ArtistGenresListItemBinding.inflate(layoutInflater, parent, false)
            return ArtistGenresListViewHolder(binding)
        }
    }
}

class ArtistGenresDiffCallback : DiffUtil.ItemCallback<Genre>() {
    override fun areItemsTheSame(oldItem: Genre, newItem: Genre): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Genre, newItem: Genre): Boolean {
        return oldItem == newItem
    }
}

class ArtistGenresClickListener(
    val clickListener: (genre: Genre?) -> Unit,
) {
    fun onClick(genre: Genre) = clickListener(genre)
}

