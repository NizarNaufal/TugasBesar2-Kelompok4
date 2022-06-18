package com.kelompok4.core.domain.repository

import kotlinx.coroutines.flow.Flow
import androidx.paging.PagedList
import com.kelompok4.core.domain.FavoriteGames
import com.kelompok4.core.domain.Games
import com.kelompok4.core.domain.source.remote.local.Resource

interface IGamesRepository {
    fun getGames(): Flow<Resource<List<Games>>>
    fun getDetailGame(gamesId: Int): Flow<Resource<Games>>
    fun getSearchGames(search: String): Flow<Resource<List<Games>>>
    fun getListGamesFavorites(): Flow<PagedList<Games>>
    fun getGamesFavorite(favoriteGamesId: Int): Flow<FavoriteGames?>
    suspend fun insertFavoriteGame(favoriteGamesId: Int)
    suspend fun deleteFavoriteGame(favoriteGamesId: Int)
}