package com.sokhibdzhon.livedota.ui.matches

import android.content.Context
import androidx.core.content.ContextCompat
import com.sokhibdzhon.livedota.R
import com.sokhibdzhon.livedota.data.local.entity.ProMatches
import com.sokhibdzhon.livedota.util.AppUtil


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

data class MatchesItemViewState(val match: ProMatches) {
    fun getMatchId(): Long = match.matchId
    fun getDireName(): String = match.direName ?: "Dire Team"
    fun getDireScore(): Int = match.direScore
    fun getDireSeriesScore(): Int = match.direSeriesScore
    fun getDuration(): String = "${AppUtil.secondsToMinutes(match.duration).toInt()}"
    fun getLeagueName(): String = match.leagueName
    fun getRadiantName(): String = match.radiantName ?: "Radiant Team"
    fun getRadiantScore(): Int = match.radiantScore
    fun getRadiantSeriesScore(): Int = match.radiantSeriesScore

    fun getFavoriteColor(context: Context): Int {
        return if (match.isFavorited) {
            ContextCompat.getColor(context, R.color.sunglo)
        } else {
            ContextCompat.getColor(context, R.color.colorWhite)
        }
    }

}


