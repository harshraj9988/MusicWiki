package com.example.musicwiki.presentation.ui

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.musicwiki.network.model.Genre

@BindingAdapter("custom_title")
fun TextView.setTitle(genre: Genre) {
    this.text = genre.name ?: ""
}

@BindingAdapter("imageBackground")
fun ImageView.loadImage(imageUrl: String?) {
    Glide.with(this.context)
        .load(imageUrl)
        .into(this)
}
