package com.example.fakenews.data.di

import com.example.fakenews.data.DataSource
import com.example.fakenews.domain.NewsInteractor
import org.koin.dsl.module


val dataModule = module {

    single<NewsInteractor> {
        DataSource()
    }
}