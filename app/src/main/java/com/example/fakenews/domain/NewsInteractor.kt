package com.example.fakenews.domain


interface NewsInteractor {

    suspend fun getNews(): List<NewsDomain>

    suspend fun insertNews(newsDomain: NewsDomain)
}