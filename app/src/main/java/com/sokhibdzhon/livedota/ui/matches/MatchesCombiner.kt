package com.sokhibdzhon.livedota.ui.matches

import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.network.model.ProMatches


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */
//TODO: Later check team names and combine same games AND ALSO get team logo ??
fun combineMatches(proMatches: Resource<List<ProMatches>>): MatchesFragmentViewState {
    return MatchesFragmentViewState(proMatches)
}

//Godlike series combiner
fun combineMatchSeries(mutableProMatches: Resource<MutableList<ProMatches>>): Resource<MutableList<ProMatches>> {
    if (mutableProMatches.data == null) {
        return mutableProMatches
    } else {
        for (i in mutableProMatches.data.indices) {
            if (mutableProMatches.data[i].radiantWin) ++mutableProMatches.data[i].radiantSeriesScore
            else ++mutableProMatches.data[i].direSeriesScore
            for (j in i + 1 until mutableProMatches.data.size) {
                if ((mutableProMatches.data[i].radiantTeamId == mutableProMatches.data[j].radiantTeamId)
                    && mutableProMatches.data[i].direTeamId == mutableProMatches.data[j].direTeamId
                ) {
                    if (mutableProMatches.data[i].radiantWin)
                        ++mutableProMatches.data[i].radiantSeriesScore
                    else ++mutableProMatches.data[i].direSeriesScore

                    mutableProMatches.data.removeAt(j)

                } else if ((mutableProMatches.data[i].radiantTeamId == mutableProMatches.data[j].direTeamId)
                    && (mutableProMatches.data[i].direTeamId == mutableProMatches.data[j].radiantTeamId)
                ) {
                    if (mutableProMatches.data[i].radiantWin) ++mutableProMatches.data[i].direSeriesScore
                    else ++mutableProMatches.data[i].radiantSeriesScore

                    mutableProMatches.data.removeAt(j)

                }
            }
        }
        return mutableProMatches
    }
}
