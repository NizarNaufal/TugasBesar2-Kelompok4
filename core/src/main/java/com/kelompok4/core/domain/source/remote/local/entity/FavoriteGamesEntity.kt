package com.kelompok4.core.domain.source.remote.local.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favoriteGamesEntity")
data class FavoriteGamesEntity(

    @PrimaryKey
    @NonNull
    val id: Int
)