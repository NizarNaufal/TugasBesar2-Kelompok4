package com.kelompok4.core.domain.source.remote.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kelompok4.core.domain.source.remote.local.entity.FavoriteGamesEntity
import com.kelompok4.core.domain.source.remote.local.entity.GamesEntity
import com.kelompok4.core.utils.Converter

@Database(
    entities = [
        GamesEntity::class,
        FavoriteGamesEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converter::class)
abstract class GamesDatabase : RoomDatabase() {
    abstract fun blownDao(): GamesDao
}