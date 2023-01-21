package com.example.musicwiki.presentation.ui.genre_info_screen.tab_layout_fragments

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.TrackListItemBinding
import com.example.musicwiki.network.model.Track

class TrackListAdapter(
    private val clickListener: TrackClickListener
) : ListAdapter<Track, TrackListViewHolder>(
    TrackDiffCallback()
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackListViewHolder {
        return TrackListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TrackListViewHolder, position: Int) {
        val track = getItem(position)
        holder.bind(track, clickListener)
    }
}

class TrackListViewHolder constructor(private val binding: TrackListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: Track,
        clickListener: TrackClickListener
    ) {
        binding.track = item
        binding.clickListener = clickListener
    }

    companion object {
        fun from(parent: ViewGroup): TrackListViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = TrackListItemBinding.inflate(layoutInflater, parent, false)
            return TrackListViewHolder(binding)
        }
    }
}

class TrackDiffCallback : DiffUtil.ItemCallback<Track>() {
    override fun areItemsTheSame(oldItem: Track, newItem: Track): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Track, newItem: Track): Boolean {
        return oldItem == newItem
    }
}

class TrackClickListener(
    val clickListener: (track: Track?) -> Unit,
) {
    fun onClick(track: Track) = clickListener(track)
}

