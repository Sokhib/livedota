package com.sokhibdzhon.livedota.data.network.steam

import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.model.MatchId
import com.sokhibdzhon.livedota.data.network.model.matchdetails.MatchDetails
import com.sokhibdzhon.livedota.data.network.model.teamitem.TeamLogo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */


class SteamDataSourceImpl @Inject constructor(val steamApiService: SteamApiService) :
    SteamDataSource {
    override fun fetchMatchDetails(matchId: MatchId): Flow<Resource<MatchDetails>> = flow {
        emit(Resource.loading())
        try {
            val matchDetails =
                steamApiService.getMatchDetailsByMatchId(matchId = matchId.value)
            emit(Resource.success(matchDetails))
        } catch (exception: Exception) {
            Timber.d("$exception")
            emit(Resource.error(exception.message ?: "Error loading Pro Matches"))
        }
    }

    override fun fetchTeamLogo(ugcId: Long): Flow<Resource<TeamLogo>> = flow {
        emit(Resource.loading())
        try {
            val teamLogo =
                steamApiService.getTeamLogo(ugcId = ugcId)
            emit(Resource.success(teamLogo))

        } catch (exception: Exception) {
            Timber.d("$exception")
            emit(Resource.error(exception.message ?: "Error loading Pro Matches"))
        }
    }
}
