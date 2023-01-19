package com.example.musicwiki.presentation.ui.genre_list_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.GenreListItemBinding
import com.example.musicwiki.network.model.Genre

class GenreListAdapter() : ListAdapter<Genre, GenreListViewHolder>(
    GenreDiffCallback()
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreListViewHolder {
        return GenreListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: GenreListViewHolder, position: Int) {
        val genre = getItem(position)
        holder.bind(genre)
    }
}

class GenreListViewHolder constructor(private val binding: GenreListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: Genre
    ) {
        binding.genre = item
    }

    companion object {
        fun from(parent: ViewGroup): GenreListViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = GenreListItemBinding.inflate(layoutInflater, parent, false)
            return GenreListViewHolder(binding)
        }
    }
}

class GenreDiffCallback : DiffUtil.ItemCallback<Genre>() {
    override fun areItemsTheSame(oldItem: Genre, newItem: Genre): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Genre, newItem: Genre): Boolean {
        return oldItem == newItem
    }
}
