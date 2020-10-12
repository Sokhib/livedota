package com.sokhibdzhon.livedota.data.network.model.matchdetails


import com.google.gson.annotations.SerializedName

data class PlayerInfo(
    @SerializedName("competitive_rank")
    val competitiveRank: Int,
    @SerializedName("leaderboard_rank")
    val leaderboardRank: Int,
    @SerializedName("mmr_estimate")
    val mmrEstimate: MmrEstimate,
    val profile: Profile,
    @SerializedName("rank_tier")
    val rankTier: Int,
    @SerializedName("solo_competitive_rank")
    val soloCompetitiveRank: Int,
    @SerializedName("tracked_until")
    val trackedUntil: Any
)