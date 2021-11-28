package com.example.fakenews.data

import com.example.fakenews.data.storage.NewsDao
import com.example.fakenews.domain.NewsDomain
import com.example.fakenews.domain.NewsInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsInteractorImpl(private val newsDao: NewsDao): NewsInteractor {

    override suspend fun getNews(): List<NewsDomain> {
        return withContext(Dispatchers.IO) {
            newsDao.getAll().map { newsEntity -> newsEntity.toNewsDomain() }
        }
    }

    override suspend fun insertNews(newsDomain: NewsDomain) {
        withContext(Dispatchers.IO) {
            newsDao.insertNews(newsDomain.toNewsEntity())
        }
    }


}