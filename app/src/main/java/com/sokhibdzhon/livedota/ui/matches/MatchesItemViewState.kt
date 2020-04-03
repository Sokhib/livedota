package com.sokhibdzhon.livedota.ui.matches

import com.sokhibdzhon.livedota.data.network.model.ProMatches
import com.sokhibdzhon.livedota.util.AppUtil


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */
//TODO: AppUtil'i boyle kullanmak dogru mu ya da @BindingAdapter ile degsitirilmeli mi?
data class MatchesItemViewState(val match: ProMatches) {
    fun getMatchId(): Long = match.matchId
    fun getDireName(): String = match.direName
    fun getDireScore(): Int = match.direScore
    fun getDireSeriesScore(): Int = match.direSeriesScore
    fun getDuration(): String = "${AppUtil.secondsToMinutes(match.duration).toInt()}'"
    fun getLeagueName(): String = match.leagueName
    fun getRadiantName(): String = match.radiantName
    fun getRadiantScore(): Int = match.radiantScore
    fun getRadiantSeriesScore(): Int = match.radiantSeriesScore

}


