package com.kelompok4.core.domain.source.remote.local.room

import androidx.paging.DataSource
import androidx.room.*
import com.kelompok4.core.domain.source.remote.local.entity.FavoriteGamesEntity
import com.kelompok4.core.domain.source.remote.local.entity.GamesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GamesDao {
    @Query("SELECT * FROM gamesEntity order by id desc")
    fun getGames(): Flow<List<GamesEntity>>

    @Query("SELECT * FROM gamesEntity where name like :search order by id desc")
    fun getSearchGames(search: String): Flow<List<GamesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGames(games: List<GamesEntity>)

    @Query("SELECT * FROM gamesEntity where id = :id")
    fun getDetailGames(id: Int): Flow<GamesEntity>

    @Update
    fun updateDetailGames(games: GamesEntity)

    @Query("SELECT * From gamesEntity a join favoriteGamesEntity b on a.id = b.id")
    fun getListGamesFavorites(): DataSource.Factory<Int, GamesEntity>

    @Query("SELECT * FROM favoriteGamesEntity where id = :id")
    fun getGamesFavorite(id: Int): Flow<FavoriteGamesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteGame(favoriteGames: FavoriteGamesEntity)

    @Delete
    fun deleteFavoriteGame(favoriteGames: FavoriteGamesEntity)
}