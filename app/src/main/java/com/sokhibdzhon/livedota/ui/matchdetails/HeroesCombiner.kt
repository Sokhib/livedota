package com.sokhibdzhon.livedota.ui.matchdetails

import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.Status
import com.sokhibdzhon.livedota.data.network.model.Heroes
import com.sokhibdzhon.livedota.data.network.model.matchdetails.MatchDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

suspend fun combineHeroesWithPicksBans(
    matchDetails: Resource<MatchDetails>,
    heroes: Resource<Heroes>
): Resource<MatchDetails> = withContext(
    Dispatchers.Default
) {
    if (heroes.status == Status.SUCCESS && matchDetails.status == Status.SUCCESS) {
        matchDetails.data?.result?.picksBans!!.forEach { pickBan ->
            heroes.data?.forEach { hero ->
                if (hero.id == pickBan.heroId) {
                    pickBan.heroName = hero.localizedName
                }
            }
        }
    }
    return@withContext matchDetails
}