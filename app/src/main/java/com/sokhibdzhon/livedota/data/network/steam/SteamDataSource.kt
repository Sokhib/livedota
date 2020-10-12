package com.sokhibdzhon.livedota.data.network.steam

import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.model.MatchId
import com.sokhibdzhon.livedota.data.network.model.matchdetails.MatchDetails
import com.sokhibdzhon.livedota.data.network.model.teamitem.TeamLogo
import kotlinx.coroutines.flow.Flow


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

interface SteamDataSource {
    fun fetchMatchDetails(matchId: MatchId): Flow<Resource<MatchDetails>>
    fun fetchTeamLogo(ugcId: Long): Flow<Resource<TeamLogo>>
}