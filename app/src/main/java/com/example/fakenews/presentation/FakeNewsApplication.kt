package com.example.fakenews.presentation

import android.app.Application
import com.example.fakenews.data.di.databaseModule
import com.example.fakenews.domain.di.domainModule
import com.example.fakenews.presentation.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FakeNewsApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin(){

        startKoin {
            androidContext(this@FakeNewsApplication)
            modules(
                databaseModule,
                domainModule,
                viewModelsModule,
            )
        }
    }
}