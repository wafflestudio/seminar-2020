package com.wafflestudio.twotyperecycler.di

import com.squareup.moshi.Moshi
import com.wafflestudio.twotyperecycler.network.service.TodoService
import com.wafflestudio.twotyperecycler.network.service.retrofit.TodoRetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(
        client: OkHttpClient,
        moshi: Moshi
    ): Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideTodoService(retrofit: Retrofit): TodoService =
        TodoService(retrofit.create(TodoRetrofitService::class.java))
}
