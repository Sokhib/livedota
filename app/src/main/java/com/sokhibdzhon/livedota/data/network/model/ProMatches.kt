package com.sokhibdzhon.livedota.data.network.model


import com.google.gson.annotations.SerializedName

data class ProMatches(
    @SerializedName("dire_name") val direName: String,
    @SerializedName("dire_score") val direScore: Int,
    @SerializedName("dire_team_id") val direTeamId: Int,
    val duration: Int,
    @SerializedName("league_name") val leagueName: String,
    @SerializedName("leagueid") val leagueId: Int,
    @SerializedName("match_id") val matchId: Long,
    @SerializedName("radiant_name") val radiantName: String,
    @SerializedName("radiant_score") val radiantScore: Int,
    @SerializedName("radiant_team_id") val radiantTeamId: Int,
    @SerializedName("radiant_win") val radiantWin: Boolean,
    @SerializedName("series_id") val seriesId: Int,
    @SerializedName("series_type") val seriesType: Int,
    @SerializedName("start_time") val startTime: Int,
    var radiantSeriesScore: Int = 0,
    var direSeriesScore: Int = 0
)