package com.example.moviedb.di

import com.example.moviedb.ui.detail.DetailViewModel
import com.example.moviedb.ui.main.DiscoverViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        DiscoverViewModel(get())
    }
    viewModel {
        DetailViewModel(get())
    }
}