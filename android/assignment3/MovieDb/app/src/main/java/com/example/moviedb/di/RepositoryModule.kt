package com.example.moviedb.di

import com.example.moviedb.repository.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        MovieRepository(get())
    }
}