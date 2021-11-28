package com.example.fakenews.data

import com.example.fakenews.data.storage.NewsEntity
import com.example.fakenews.domain.NewsDomain
import com.example.fakenews.presentation.recycler.News

fun NewsEntity.toNewsDomain() =
    NewsDomain(
        title = title,
        image = image,
        author = author,
        date = date,
        topic = topic,
        text = text
    )

fun NewsDomain.toNewsEntity() =
    NewsEntity(
        title = title,
        image = image,
        author = author,
        date = date,
        topic = topic,
        text = text
    )

fun NewsDomain.toNews() =
    News(
        title = title,
        image = image,
        author = author,
        date = date,
        topic = topic,
        text = text
    )

fun News.toNewsDomain() =
    NewsDomain(
        title = title,
        image = image,
        author = author,
        date = date,
        topic = topic,
        text = text
    )

