package com.sanggggg.roomexample.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sanggggg.roomexample.databinding.ItemMemoBinding
import com.sanggggg.roomexample.db.Memo

class MemoListAdapter : RecyclerView.Adapter<MemoViewHolder>() {
    private val items = mutableListOf<Memo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        val binding = ItemMemoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MemoViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        holder.bindMemo(items[position])
    }

    fun setItems(memos: List<Memo>) {
        items.clear()
        items.addAll(memos)
        notifyDataSetChanged()
    }
}

class MemoViewHolder(private val binding: ItemMemoBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindMemo(memo: Memo) {
        binding.memo = memo
    }
}