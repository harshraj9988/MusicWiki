package com.example.musicwiki.presentation.ui.genre_info_screen.tab_layout_fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.GenreTrackListItemBinding
import com.example.musicwiki.network.model.Track

class GenreTrackListAdapter(
    private val clickListener: GenreTrackClickListener
) : ListAdapter<Track, GenreTrackListViewHolder>(
    GenreTrackDiffCallback()
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreTrackListViewHolder {
        return GenreTrackListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: GenreTrackListViewHolder, position: Int) {
        val track = getItem(position)
        holder.bind(track, clickListener)
    }
}

class GenreTrackListViewHolder constructor(private val binding: GenreTrackListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: Track,
        clickListener: GenreTrackClickListener
    ) {
        binding.track = item
        binding.clickListener = clickListener
    }

    companion object {
        fun from(parent: ViewGroup): GenreTrackListViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = GenreTrackListItemBinding.inflate(layoutInflater, parent, false)
            return GenreTrackListViewHolder(binding)
        }
    }
}

class GenreTrackDiffCallback : DiffUtil.ItemCallback<Track>() {
    override fun areItemsTheSame(oldItem: Track, newItem: Track): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Track, newItem: Track): Boolean {
        return oldItem == newItem
    }
}

class GenreTrackClickListener(
    val clickListener: (track: Track?) -> Unit,
) {
    fun onClick(track: Track) = clickListener(track)
}

