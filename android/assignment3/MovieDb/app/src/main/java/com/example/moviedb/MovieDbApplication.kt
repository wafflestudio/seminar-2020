package com.example.moviedb

import android.app.Application
import com.example.moviedb.di.networkModule
import com.example.moviedb.di.repositoryModule
import com.example.moviedb.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieDbApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MovieDbApplication)
            modules(listOf(networkModule, viewModelModule, repositoryModule))
        }
    }
}