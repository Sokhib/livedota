package com.sokhibdzhon.livedota.ui.matches

import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.local.entity.ProMatches
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

//Godlike series combiner
suspend fun combineMatchSeries(mutableProMatches: Resource<MutableList<ProMatches>>): Resource<MutableList<ProMatches>> =
    withContext(Dispatchers.Default) {
        if (mutableProMatches.data == null) {
            mutableProMatches
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
            mutableProMatches
        }
    }
