package com.kelompok4.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.kelompok4.core.domain.usecase.IGamesUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val iBlownUseCase: IGamesUseCase,
    private val coroutineDispatcher: CoroutineDispatcher
) : ViewModel() {
    val favoriteGames = iBlownUseCase.getListGamesFavorites().asLiveData()

    fun deleteFavoriteGames(favoriteGamesId: Int) = viewModelScope.launch(coroutineDispatcher) {
        iBlownUseCase.deleteFavoriteGame(favoriteGamesId)
    }
}