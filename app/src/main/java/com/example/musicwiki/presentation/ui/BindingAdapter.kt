package com.example.musicwiki.presentation.ui

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.musicwiki.network.model.Genre

@BindingAdapter("custom_title")
fun TextView.setTitle(genre: Genre) {
    this.text = genre.name ?: ""
}
