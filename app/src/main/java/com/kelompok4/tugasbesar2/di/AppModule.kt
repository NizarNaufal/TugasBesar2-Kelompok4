package com.kelompok4.tugasbesar2.di

import kotlinx.coroutines.Dispatchers
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<IGamesUseCase> {
        GamesUseCase(get())
    }
}

val viewModelModule = module {
    factory {
        Dispatchers.IO
    }
    viewModel {
        HomeViewModel(get())
    }
    viewModel {
        SearchViewModel(get())
    }
    viewModel {
        DetailViewModel(get(), get())
    }
}