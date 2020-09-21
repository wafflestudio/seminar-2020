package com.sanggggg.roomexample.utils

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sanggggg.roomexample.db.Memo
import com.sanggggg.roomexample.ui.MemoListAdapter

@BindingAdapter("adapter")
fun bindRecyclerViewAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("items")
fun bindItems(view: RecyclerView, memo: List<Memo>) {
    val adapter = view.adapter as? MemoListAdapter
    adapter?.setItems(memo)
}