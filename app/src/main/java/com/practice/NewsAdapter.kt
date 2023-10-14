package com.practice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.practice.databinding.ItemImageBinding
import com.practice.databinding.ItemNewsBinding
import com.practice.model.Image
import com.practice.model.News

class NewsAdapter : ListAdapter<News, NewsAdapter.ViewHolder>(diffCallback) {
    inner class ViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: News) {
            binding.item = item
        }
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<News>() {
            override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
                return oldItem.title === newItem.title
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}