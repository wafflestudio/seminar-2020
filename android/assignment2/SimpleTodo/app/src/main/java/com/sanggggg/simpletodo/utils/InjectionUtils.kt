package com.sanggggg.simpletodo.utils

import android.content.Context
import com.sanggggg.simpletodo.room.TodoRepository
import com.sanggggg.simpletodo.viewmodel.TodoViewModelFactory


// Already completed
// Do not modify
object InjectionUtils {

    fun provideTodoViewModelFactory(context: Context): TodoViewModelFactory {
        val repository = TodoRepository(context)
        return TodoViewModelFactory(repository)
    }
}