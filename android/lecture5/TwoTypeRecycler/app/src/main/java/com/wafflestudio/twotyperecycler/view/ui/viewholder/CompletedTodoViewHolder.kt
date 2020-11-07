package com.wafflestudio.twotyperecycler.view.ui.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wafflestudio.twotyperecycler.R
import com.wafflestudio.twotyperecycler.model.CompletedTodo
import kotlinx.android.synthetic.main.item_todo_completed.view.*

class CompletedTodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val titleText: TextView = view.title_text
    private val completerIdText: TextView = view.completer_id_text

    fun render(todo: CompletedTodo) {
        titleText.text = todo.title
        completerIdText.text = itemView.context.getString(R.string.user_id, todo.userId)
    }
}
