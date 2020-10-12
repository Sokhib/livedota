package com.sokhibdzhon.livedota.data.repository

import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.local.entity.ProMatches
import com.sokhibdzhon.livedota.data.model.MatchId
import com.sokhibdzhon.livedota.data.network.model.heroes.Heroes
import com.sokhibdzhon.livedota.data.network.model.matchdetails.MatchDetails
import com.sokhibdzhon.livedota.data.network.model.matchdetails.Player
import com.sokhibdzhon.livedota.data.network.model.matchdetails.PlayerInfo
import com.sokhibdzhon.livedota.data.network.model.teamitem.TeamLogo
import kotlinx.coroutines.flow.Flow


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

interface Repository {
    //Local
    fun getProMatchesFromDb(): Flow<List<ProMatches>>
    suspend fun addMatchToFavorite(proMatches: ProMatches)
    suspend fun removeMatchFromFavorite(match: ProMatches)

    //Steam
    fun fetchMatchDetails(matchId: MatchId): Flow<Resource<MatchDetails>>
    fun fetchTeamLogo(ugcId: Long): Flow<Resource<TeamLogo>>

    //OpenDota
    fun fetchProMatches(): Flow<Resource<List<ProMatches>>>
    fun fetchHeroes(): Flow<Resource<Heroes>>
    fun fetchPlayer(playerIds: List<Player>): Flow<Resource<PlayerInfo>>

}