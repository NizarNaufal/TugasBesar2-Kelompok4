package com.kelompok4.tugasbesar2.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kelompok4.core.domain.usecase.IGamesUseCase

class SearchViewModel(iBlownUseCase: IGamesUseCase) : ViewModel() {
    private val searchText = MutableLiveData<String>()

    fun setGameDetailId(searchText: String) {
        this.searchText.value = searchText
    }

    val searchGames = Transformations.switchMap(searchText) {
        iBlownUseCase.getSearchGames(it).asLiveData()
    }
}