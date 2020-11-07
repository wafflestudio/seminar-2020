package com.wafflestudio.twotyperecycler.network.service.retrofit

import com.wafflestudio.twotyperecycler.network.dto.TodoDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface TodoRetrofitService {
    @GET("todos")
    fun getTodos(): Single<List<TodoDto>>
}
