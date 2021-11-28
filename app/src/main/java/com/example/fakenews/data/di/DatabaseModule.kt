package com.example.fakenews.data.di

import androidx.room.Room
import com.example.fakenews.data.storage.AppDatabase
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "news"
        ).build()
    }

    single {
        get<AppDatabase>().newsDao()
    }
}