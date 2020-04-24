package com.sokhibdzhon.livedota.data.network.steam

import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.network.model.matchdetails.MatchDetails
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
    }


}
