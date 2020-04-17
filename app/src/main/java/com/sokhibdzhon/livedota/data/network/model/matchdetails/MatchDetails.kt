package com.sokhibdzhon.livedota.data.network.model.matchdetails


import com.google.gson.annotations.SerializedName

data class MatchDetails(
    @SerializedName("barracks_status_dire")
    val barracksStatusDire: Int,
    @SerializedName("barracks_status_radiant")
    val barracksStatusRadiant: Int,
    @SerializedName("dire_score")
    val direScore: Int,
    @SerializedName("dire_team")
    val direTeam: DireTeam,
    @SerializedName("dire_team_id")
    val direTeamId: Int,
    val duration: Int,
    val league: League,
    val leagueid: Int,
    @SerializedName("match_id")
    val matchId: Long,
    @SerializedName("picks_bans")
    val picksBans: List<PicksBan>,
    val players: List<Player>,
    @SerializedName("radiant_score")
    val radiantScore: Int,
    @SerializedName("radiant_team")
    val radiantTeam: RadiantTeam,
    @SerializedName("radiant_team_id")
    val radiantTeamId: Int,
    @SerializedName("radiant_win")
    val radiantWin: Boolean,
    @SerializedName("replay_url")
    val replayUrl: String,
    @SerializedName("series_id")
    val seriesId: Int,
    @SerializedName("series_type")
    val seriesType: Int,
    @SerializedName("start_time")
    val startTime: Int
)