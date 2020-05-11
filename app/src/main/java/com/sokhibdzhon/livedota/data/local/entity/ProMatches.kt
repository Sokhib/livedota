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
    @SerializedName("match_id") val matchId: Long = (0..Long.MAX_VALUE).random(),
    @SerializedName("dire_name") val direName: String?,
    @SerializedName("dire_score") val direScore: Int = 0,
    @SerializedName("dire_series_score") var direSeriesScore: Int = 0,
    @SerializedName("dire_team_id") val direTeamId: Int? = 0,
    val duration: Int = 0,
    var isFavorited: Boolean = false,
    @SerializedName("league_name") val leagueName: String = "Tournament Name",
    @SerializedName("leagueid") val leagueId: Int = 0,
    @SerializedName("radiant_name") val radiantName: String? = "Radiant Team",
    @SerializedName("radiant_score") val radiantScore: Int = 0,
    @SerializedName("radiant_series_score") var radiantSeriesScore: Int = 0,
    @SerializedName("radiant_team_id") val radiantTeamId: Int? = 0,
    @SerializedName("radiant_win") val radiantWin: Boolean = false,
    @SerializedName("series_id") val seriesId: Int = 0,
    @SerializedName("series_type") val seriesType: Int = 0,
    @SerializedName("start_time") val startTime: Int = 0
)