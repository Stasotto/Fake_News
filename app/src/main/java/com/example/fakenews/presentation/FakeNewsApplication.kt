package com.example.fakenews.presentation

import android.app.Application
import com.example.fakenews.data.di.dataModule
import com.example.fakenews.presentation.di.viewModelsMode
import org.koin.core.context.startKoin

class FakeNewsApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin(){
        startKoin {
            modules(
                viewModelsMode,
                dataModule
            )
        }
    }
}