package com.kelompok4.core.domain.usecase

import kotlinx.coroutines.flow.Flow
import androidx.paging.PagedList
import com.kelompok4.core.domain.FavoriteGames
import com.kelompok4.core.domain.Games
import com.kelompok4.core.domain.repository.IGamesRepository
import com.kelompok4.core.domain.source.remote.local.Resource

class GamesUseCase(private val iGamesRepository: IGamesRepository) : IGamesUseCase {
    override fun getGames(): Flow<Resource<List<Games>>> = iGamesRepository.getGames()

    override fun getDetailGame(gamesId: Int): Flow<Resource<Games>> =
        iGamesRepository.getDetailGame(gamesId)

    override fun getSearchGames(search: String): Flow<Resource<List<Games>>> =
        iGamesRepository.getSearchGames(search)

    override fun getListGamesFavorites(): Flow<PagedList<Games>> =
        iGamesRepository.getListGamesFavorites()

    override fun getGamesFavorite(favoriteGamesId: Int): Flow<FavoriteGames?> =
        iGamesRepository.getGamesFavorite(favoriteGamesId)

    override suspend fun insertFavoriteGame(favoriteGamesId: Int) =
        iGamesRepository.insertFavoriteGame(favoriteGamesId)

    override suspend fun deleteFavoriteGame(favoriteGamesId: Int) =
        iGamesRepository.deleteFavoriteGame(favoriteGamesId)
}