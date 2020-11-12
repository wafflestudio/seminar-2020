package com.wafflestudio.twotyperecycler.view.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.wafflestudio.twotyperecycler.model.Todo
import com.wafflestudio.twotyperecycler.network.service.TodoService
import io.reactivex.rxjava3.core.Single

class MainViewModel @ViewModelInject constructor(
    private val todoService: TodoService
) : ViewModel() {

    fun getTodos(): Single<List<Todo>> = todoService.getTodos()
}
