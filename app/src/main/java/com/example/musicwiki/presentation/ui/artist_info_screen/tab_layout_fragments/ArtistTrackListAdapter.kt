package com.example.musicwiki.presentation.ui.artist_info_screen.tab_layout_fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.ArtistTrackListItemBinding
import com.example.musicwiki.network.model.Track

class ArtistTrackListAdapter(
    private val clickListener: ArtistTrackClickListener
) : ListAdapter<Track, ArtistTrackListViewHolder>(
    ArtistTrackDiffCallback()
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistTrackListViewHolder {
        return ArtistTrackListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ArtistTrackListViewHolder, position: Int) {
        val track = getItem(position)
        holder.bind(track, clickListener)
    }
}

class ArtistTrackListViewHolder constructor(private val binding: ArtistTrackListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: Track,
        clickListener: ArtistTrackClickListener
    ) {
        binding.track = item
        binding.clickListener = clickListener
    }

    companion object {
        fun from(parent: ViewGroup): ArtistTrackListViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ArtistTrackListItemBinding.inflate(layoutInflater, parent, false)
            return ArtistTrackListViewHolder(binding)
        }
    }
}

class ArtistTrackDiffCallback : DiffUtil.ItemCallback<Track>() {
    override fun areItemsTheSame(oldItem: Track, newItem: Track): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Track, newItem: Track): Boolean {
        return oldItem == newItem
    }
}

class ArtistTrackClickListener(
    val clickListener: (track: Track?) -> Unit,
) {
    fun onClick(track: Track) = clickListener(track)
}

