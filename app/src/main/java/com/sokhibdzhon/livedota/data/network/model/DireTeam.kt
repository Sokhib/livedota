package com.sokhibdzhon.livedota.data.network.model


import com.google.gson.annotations.SerializedName

data class DireTeam(
    @SerializedName("logo_url")
    val logoUrl: String,
    val name: String,
    val tag: String,
    @SerializedName("team_id")
    val teamId: Int
)