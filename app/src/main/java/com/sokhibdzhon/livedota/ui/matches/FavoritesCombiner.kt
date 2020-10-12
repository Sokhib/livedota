package com.sokhibdzhon.livedota.ui.matches

import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.Status
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


suspend fun combineFavorites(
    proMatches: Resource<List<ProMatches>>,
    favoritedMatches: List<ProMatches>
): Resource<List<ProMatches>> = withContext(
    Dispatchers.Default
) {
    if (proMatches.status == Status.SUCCESS) {
        favoritedMatches.forEach { favoredMatch ->
            proMatches.data?.forEach { proMatch ->
                if (favoredMatch.matchId == proMatch.matchId) {
                    proMatch.isFavorited = true
                }
            }
        }

    }
    return@withContext proMatches
}