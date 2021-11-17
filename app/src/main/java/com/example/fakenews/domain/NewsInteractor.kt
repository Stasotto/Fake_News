package com.example.fakenews.domain

import com.example.fakenews.presentation.recycler.News

interface NewsInteractor {
    fun loadNews(): List<News>
}