package com.kelompok4.tugasbesar2.di

import com.kelompok4.core.domain.usecase.GamesUseCase
import com.kelompok4.core.domain.usecase.IGamesUseCase
import com.kelompok4.tugasbesar2.ui.detail.DetailViewModel
import com.kelompok4.tugasbesar2.ui.home.HomeViewModel
import com.kelompok4.tugasbesar2.ui.search.SearchViewModel
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