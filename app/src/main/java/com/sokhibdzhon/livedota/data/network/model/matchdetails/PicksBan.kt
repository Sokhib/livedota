package com.sokhibdzhon.livedota.data.network.model.matchdetails


import com.google.gson.annotations.SerializedName

data class PicksBan(
    @SerializedName("hero_id")
    val heroId: Int,
    @SerializedName("is_pick")
    val isPick: Boolean,
    val order: Int,
    val team: Int,
    var heroName: String = ""
)