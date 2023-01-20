package com.example.musicwiki.presentation.ui

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.musicwiki.R
import com.example.musicwiki.network.model.Album
import com.example.musicwiki.network.model.Artist
import com.example.musicwiki.network.model.Genre
import com.example.musicwiki.network.model.Track

const val DEFAULT_IMAGE = R.drawable.default_image

@BindingAdapter("genre_title")
fun TextView.setTitle(genre: Genre?) {
    this.text = genre?.name ?: ""
}

@BindingAdapter("album_title")
fun TextView.setTitle(album: Album?) {
    this.text = album?.name ?: ""
}

@BindingAdapter("artist_title")
fun TextView.setTitle(artist: Artist?) {
    this.text = artist?.name ?: ""
}

@BindingAdapter("track_title")
fun TextView.setTitle(track: Track?) {
    this.text = track?.name ?: ""
}


@BindingAdapter("album_cover_image")
fun ImageView.loadImage(album: Album?) {
    Glide.with(this.context)
        .load(album?.images?.get(2)?.url)
        .error(DEFAULT_IMAGE)
        .placeholder(DEFAULT_IMAGE)
        .fallback(DEFAULT_IMAGE)
        .into(this)
}

@BindingAdapter("artist_cover_image")
fun ImageView.loadImage(artist: Artist?) {
    Glide.with(this.context)
        .load(artist?.images?.get(2)?.url)
        .error(DEFAULT_IMAGE)
        .placeholder(DEFAULT_IMAGE)
        .fallback(DEFAULT_IMAGE)
        .into(this)
}

@BindingAdapter("track_cover_image")
fun ImageView.loadImage(track: Track?) {
    Glide.with(this.context)
        .load(track?.images?.get(2)?.url)
        .error(DEFAULT_IMAGE)
        .placeholder(DEFAULT_IMAGE)
        .fallback(DEFAULT_IMAGE)
        .into(this)
}
