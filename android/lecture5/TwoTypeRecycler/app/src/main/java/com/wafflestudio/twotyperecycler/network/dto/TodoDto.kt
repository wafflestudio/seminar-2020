package com.wafflestudio.twotyperecycler.network.dto

data class TodoDto(
    val userId: Long,
    val id: Long,
    val title: String,
    val completed: Boolean
)
