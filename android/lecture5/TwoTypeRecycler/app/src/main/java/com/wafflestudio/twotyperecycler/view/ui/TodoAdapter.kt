package com.wafflestudio.twotyperecycler.view.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wafflestudio.twotyperecycler.R
import com.wafflestudio.twotyperecycler.model.CompletedTodo
import com.wafflestudio.twotyperecycler.model.PendingTodo
import com.wafflestudio.twotyperecycler.model.Todo
import com.wafflestudio.twotyperecycler.view.ui.viewholder.CompletedTodoViewHolder
import com.wafflestudio.twotyperecycler.view.ui.viewholder.PendingTodoViewHolder

class TodoAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var todos: List<Todo> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            TODO_COMPLETED_VIEW_TYPE -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_todo_completed, parent, false)
                    .let { CompletedTodoViewHolder(it) }
            }
            TODO_PENDING_VIEW_TYPE -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_todo_pending, parent, false)
                    .let { PendingTodoViewHolder(it) }
            }
            else -> throw IllegalStateException("viewType must be 0 or 1")
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CompletedTodoViewHolder -> {
                (todos[position] as? CompletedTodo)?.let { holder.render(it) }
            }
            is PendingTodoViewHolder -> {
                (todos[position] as? PendingTodo)?.let { holder.render(it) }
            }
        }
    }

    override fun getItemCount(): Int = todos.size

    override fun getItemViewType(position: Int): Int = when (todos[position]) {
        is CompletedTodo -> TODO_COMPLETED_VIEW_TYPE
        is PendingTodo -> TODO_PENDING_VIEW_TYPE
    }

    companion object {
        private const val TODO_COMPLETED_VIEW_TYPE = 0
        private const val TODO_PENDING_VIEW_TYPE = 1
    }
}