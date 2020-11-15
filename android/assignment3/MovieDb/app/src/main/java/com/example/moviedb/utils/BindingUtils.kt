package com.example.moviedb.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.example.moviedb.R

@BindingAdapter("setImageUrl")
fun bindImageUrl(view: ImageView, url: String?) {
    Glide.with(view.context)
        .load("https://image.tmdb.org/t/p/w500/${url}")
        .placeholder(R.drawable.ic_baseline_local_movies_24)
        .into(view)
}