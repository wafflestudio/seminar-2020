package com.sanggggg.simpletodo.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao {
    // TODO: Add the queries(interaction) on the specification
    // example - fun deleteTodo ... fun getAllTodos ...

    @Insert
    fun insertTodo(todo: Todo)

}