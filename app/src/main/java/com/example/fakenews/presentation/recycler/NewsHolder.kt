package com.example.fakenews.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fakenews.R
import com.example.fakenews.databinding.NewsItemBinding

class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding: NewsItemBinding by lazy { NewsItemBinding.bind(itemView) }

    companion object {
        fun from(parent: ViewGroup): NewsHolder {
            return NewsHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.news_item, parent, false)
            )
        }
    }

    fun bind(item: News) = with(binding) {
        title.text = item.title
        image.setImageResource(item.image)
        author.text = item.author
        date.text = item.date
        topic.text = item.topic
        text.text = item.text
    }

}
