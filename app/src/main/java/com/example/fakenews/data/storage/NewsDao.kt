package com.example.fakenews.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NewsDao {

    @Query("SELECT * FROM news")
    fun getAll(): List<NewsEntity>

    @Insert
    fun insertNews(news: NewsEntity)
}