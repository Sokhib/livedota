package com.sokhibdzhon.livedota.data.network.steam

import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.network.model.matchdetails.MatchDetails
import kotlinx.coroutines.flow.Flow


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

interface SteamDataSource {
    fun fetchMatchDetails(matchId: Long): Flow<Resource<MatchDetails>>
}