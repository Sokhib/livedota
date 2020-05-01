package com.sokhibdzhon.livedota.data.network.steam

import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.Status
import com.sokhibdzhon.livedota.data.network.model.matchdetails.MatchDetails
import com.sokhibdzhon.livedota.data.network.model.teamitem.TeamLogo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
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
    private var radiantTeamLogo: Long = 0L
    private var direTeamLogo: Long = 0L
    override fun fetchMatchDetails(matchId: Long): Flow<Resource<MatchDetails>> = flow {
        emit(Resource.loading())
        try {
            val matchDetails =
                steamApiService.getMatchDetailsByMatchId(matchId = matchId)
            emit(Resource.success(matchDetails))
        } catch (exception: Exception) {
            Timber.d("$exception")
            emit(Resource.error<MatchDetails>(exception.message ?: "Error loading Pro Matches"))
        }
    }.map {
        if (it.status == Status.SUCCESS) {
            radiantTeamLogo = it.data?.result?.radiantLogo!!
            direTeamLogo = it.data.result.direLogo
        }
        it
    }

    override fun fetchTeamLogo(ugcId: Long): Flow<Resource<TeamLogo>> = flow {
        emit(Resource.loading())
        try {
            Timber.d("UGCID: $ugcId")
            val teamLogo =
                steamApiService.getTeamLogo(ugcId = ugcId)
            emit(Resource.success(teamLogo))

        } catch (exception: Exception) {
            Timber.d("$exception")
            emit(Resource.error<TeamLogo>(exception.message ?: "Error loading Pro Matches"))
        }
    }


}
