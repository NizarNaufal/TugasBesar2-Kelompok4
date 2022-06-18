package com.kelompok4.core.domain.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListGamesResponse(

    @field:SerializedName("results")
    val results: List<GamesResponse>
)