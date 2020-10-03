package com.example.retrofitexample.api

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    fun fetchAllPosts(): Observable<List<PostDto>>

}