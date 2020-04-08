package com.sokhibdzhon.livedota.data.network.model


import com.google.gson.annotations.SerializedName

data class ProMatches(
    @SerializedName("dire_name") val direName: String = "Dire Team",
    @SerializedName("dire_score") val direScore: Int = 0,
    @SerializedName("dire_team_id") val direTeamId: Int = 1,
    val duration: Int = 0,
    @SerializedName("league_name") val leagueName: String = "League Name",
    @SerializedName("leagueid") val leagueId: Int = 0,
    @SerializedName("match_id") val matchId: Long = 0L,
    @SerializedName("radiant_name") val radiantName: String = "Radiant Team",
    @SerializedName("radiant_score") val radiantScore: Int = 0,
    @SerializedName("radiant_team_id") val radiantTeamId: Int = 0,
    @SerializedName("radiant_win") val radiantWin: Boolean = true,
    @SerializedName("series_id") val seriesId: Int = 0,
    @SerializedName("series_type") val seriesType: Int = 0,
    @SerializedName("start_time") val startTime: Int = 0,
    var radiantSeriesScore: Int = 0,
    var direSeriesScore: Int = 0
)