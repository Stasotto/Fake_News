package com.example.fakenews.presentation.di

import com.example.fakenews.presentation.viewmodel.DataViewModel
import org.koin.androidx.viewmodel.dsl.viewModel


import org.koin.dsl.module

val viewModelsMode = module {

    viewModel {
        DataViewModel(interactor = get())
    }
}

