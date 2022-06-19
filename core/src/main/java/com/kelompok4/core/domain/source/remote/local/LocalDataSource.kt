package com.kelompok4.core.domain.source.remote.local

import androidx.paging.DataSource
import com.kelompok4.core.domain.source.remote.local.entity.FavoriteGamesEntity
import com.kelompok4.core.domain.source.remote.local.entity.GamesEntity
import com.kelompok4.core.domain.source.remote.local.room.GamesDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val blownDao: GamesDao) {

    fun getGames(): Flow<List<GamesEntity>> = blownDao.getGames()

    fun getSearchGames(search: String): Flow<List<GamesEntity>> =
        blownDao.getSearchGames("$search%")

    fun insertGames(games: List<GamesEntity>) = blownDao.insertGames(games)

    fun getDetailGames(id: Int): Flow<GamesEntity> = blownDao.getDetailGames(id)

    fun updateDetailGames(games: GamesEntity) = blownDao.updateDetailGames(games)

    fun getListGamesFavorites(): DataSource.Factory<Int, GamesEntity> =
        blownDao.getListGamesFavorites()

    fun getGamesFavorite(id: Int): Flow<FavoriteGamesEntity> = blownDao.getGamesFavorite(id)

    fun insertFavoriteGame(favoriteGames: FavoriteGamesEntity) =
        blownDao.insertFavoriteGame(favoriteGames)

    fun deleteFavoriteGame(favoriteGames: FavoriteGamesEntity) =
        blownDao.deleteFavoriteGame(favoriteGames)
}