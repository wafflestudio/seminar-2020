package com.wafflestudio.twotyperecycler.model

sealed class Todo
data class CompletedTodo(val userId: Long, val id: Long, val title: String) : Todo()
data class PendingTodo(val id: Long, val title: String) : Todo()
