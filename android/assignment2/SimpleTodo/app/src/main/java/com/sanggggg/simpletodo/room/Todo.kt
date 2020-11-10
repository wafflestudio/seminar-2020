package com.sanggggg.simpletodo.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Already completed
// Do not modify
@Entity(tableName = "todo_table")
data class Todo(
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "content")
    var content: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}