package com.sokhibdzhon.livedota.data.network.model.matchdetails


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("dire_captain")
    val direCaptain: Int,
    @SerializedName("dire_logo")
    val direLogo: Long,
    @SerializedName("dire_name")
    val direName: String,
    @SerializedName("dire_score")
    val direScore: Int,
    @SerializedName("dire_team_complete")
    val direTeamComplete: Int,
    @SerializedName("dire_team_id")
    val direTeamId: Int,
    val duration: Int,
    val engine: Int,
    val flags: Int,
    @SerializedName("game_mode")
    val gameMode: Int,
    val leagueid: Int,
    @SerializedName("lobby_type")
    val lobbyType: Int,
    @SerializedName("match_id")
    val matchId: Long,
    @SerializedName("match_seq_num")
    val matchSeqNum: Long,
    @SerializedName("picks_bans")
    val picksBans: List<PicksBan>,
    val players: List<Player>,
    @SerializedName("radiant_captain")
    val radiantCaptain: Int,
    @SerializedName("radiant_logo")
    val radiantLogo: Long,
    @SerializedName("radiant_name")
    val radiantName: String,
    @SerializedName("radiant_score")
    val radiantScore: Int,
    @SerializedName("radiant_team_complete")
    val radiantTeamComplete: Int,
    @SerializedName("radiant_team_id")
    val radiantTeamId: Int,
    @SerializedName("radiant_win")
    val radiantWin: Boolean,
    @SerializedName("start_time")
    val startTime: Int
)