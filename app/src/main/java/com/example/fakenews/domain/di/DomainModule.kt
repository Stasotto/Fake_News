package com.example.fakenews.domain.di

import com.example.fakenews.data.NewsInteractorImpl
import com.example.fakenews.domain.NewsInteractor
import org.koin.dsl.module

val domainModule = module {

    single<NewsInteractor>{

        NewsInteractorImpl(newsDao = get())
    }
}