package com.sanggggg.simpletodo.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanggggg.simpletodo.databinding.ItemTodoBinding
import com.sanggggg.simpletodo.room.Todo
import com.sanggggg.simpletodo.viewmodel.TodoViewModel

// TODO: Complete TodoListAdapter
class TodoListAdapter(private val viewModel: TodoViewModel) : RecyclerView.Adapter<TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding, viewModel)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}

// TODO: Complete TodoViewHolder
class TodoViewHolder(private val binding: ItemTodoBinding, private val viewModel: TodoViewModel) : RecyclerView.ViewHolder(binding.root) {
    fun bindTodo(todo: Todo) {

    }
}