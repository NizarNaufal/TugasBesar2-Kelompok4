package com.kelompok4.tugasbesar2.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kelompok4.core.domain.usecase.IGamesUseCase

class HomeViewModel(iBlownUseCase: IGamesUseCase) : ViewModel() {
    val games = iBlownUseCase.getGames().asLiveData()
}