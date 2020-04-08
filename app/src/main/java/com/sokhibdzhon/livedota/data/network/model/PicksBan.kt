package com.sokhibdzhon.livedota.data.network.model


import com.google.gson.annotations.SerializedName

data class PicksBan(
    @SerializedName("hero_id")
    val heroId: Int,
    @SerializedName("is_pick")
    val isPick: Boolean,
    @SerializedName("match_id")
    val matchId: Long,
    val ord: Int,
    val order: Int,
    val team: Int
)