package com.example.retrofitexample

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitexample.api.PostDto
import com.example.retrofitexample.databinding.ItemPostBinding

class PostListAdapter : RecyclerView.Adapter<PostViewHolder>() {
    private val items = mutableListOf<PostDto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    fun setPosts(posts: List<PostDto>) {
        items.clear()
        items.addAll(posts)
        notifyDataSetChanged()
    }
}

class PostViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindItem(post: PostDto) {
        binding.post = post
    }

}