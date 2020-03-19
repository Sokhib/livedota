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
    fun getDireName(): String = match.direName
    fun getDireSeriesScore(): Int = match.direSeriesScore
    fun getDuration(): Int = AppUtil.secondsToMinutes(match.duration).toInt()
    fun getLeagueName(): String = match.leagueName
    fun getRadiantName(): String = match.radiantName
    fun getRadiantSeriesScore(): Int = match.radiantSeriesScore

}


