package com.wafflestudio.twotyperecycler.network.service

import com.wafflestudio.twotyperecycler.model.CompletedTodo
import com.wafflestudio.twotyperecycler.model.PendingTodo
import com.wafflestudio.twotyperecycler.model.Todo
import com.wafflestudio.twotyperecycler.network.service.retrofit.TodoRetrofitService
import io.reactivex.rxjava3.core.Single

class TodoService(
    private val todoRetrofitService: TodoRetrofitService
) {
    fun getTodos(): Single<List<Todo>> = todoRetrofitService.getTodos()
        .map { todos ->
            todos.map { todo ->
                if (todo.completed) {
                    CompletedTodo(todo.userId, todo.id, todo.title)
                } else {
                    PendingTodo(todo.id, todo.title)
                }
            }
        }
}
