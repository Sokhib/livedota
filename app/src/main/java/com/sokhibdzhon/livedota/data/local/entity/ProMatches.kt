package com.sokhibdzhon.livedota.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

@Entity(tableName = "pro_matches")
data class ProMatches(
    @PrimaryKey
    @SerializedName("match_id") val matchId: Long,
    @SerializedName("dire_name") val direName: String?,
    @SerializedName("dire_score") val direScore: Int,
    @SerializedName("dire_series_score") var direSeriesScore: Int = 0,
    @SerializedName("dire_team_id") val direTeamId: Int?,
    val duration: Int,
    @SerializedName("league_name") val leagueName: String,
    @SerializedName("leagueid") val leagueId: Int,
    @SerializedName("radiant_name") val radiantName: String?,
    @SerializedName("radiant_score") val radiantScore: Int,
    @SerializedName("radiant_series_score") var radiantSeriesScore: Int = 0,
    @SerializedName("radiant_team_id") val radiantTeamId: Int?,
    @SerializedName("radiant_win") val radiantWin: Boolean,
    @SerializedName("series_id") val seriesId: Int,
    @SerializedName("series_type") val seriesType: Int,
    @SerializedName("start_time") val startTime: Int
)