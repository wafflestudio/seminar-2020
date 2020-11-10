package com.wafflestudio.twotyperecycler.view.ui.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wafflestudio.twotyperecycler.model.PendingTodo
import kotlinx.android.synthetic.main.item_todo_pending.view.*

class PendingTodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val titleText: TextView = view.title_text

    fun render(todo: PendingTodo) {
        titleText.text = todo.title
    }
}
