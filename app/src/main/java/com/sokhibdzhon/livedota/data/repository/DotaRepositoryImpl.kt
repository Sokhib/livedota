package com.sokhibdzhon.livedota.data.repository

import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.local.FavoriteMatchesDao
import com.sokhibdzhon.livedota.data.local.entity.ProMatches
import com.sokhibdzhon.livedota.data.network.model.heroes.Heroes
import com.sokhibdzhon.livedota.data.network.model.matchdetails.MatchDetails
import com.sokhibdzhon.livedota.data.network.model.matchdetails.Player
import com.sokhibdzhon.livedota.data.network.model.matchdetails.PlayerInfo
import com.sokhibdzhon.livedota.data.network.model.teamitem.TeamLogo
import com.sokhibdzhon.livedota.data.network.opendota.OpenDotaDataSource
import com.sokhibdzhon.livedota.data.network.steam.SteamDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber
import javax.inject.Inject


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

class DotaRepositoryImpl @Inject constructor(
    private val steamDataSourceImpl: SteamDataSource,
    private val openDotaDataSourceImpl: OpenDotaDataSource,
    private val favoriteMatchesDao: FavoriteMatchesDao
) : Repository {
    @ExperimentalCoroutinesApi
    override fun getProMatchesFromDb(): Flow<List<ProMatches>> {
        return favoriteMatchesDao.getProMatches().flowOn(Dispatchers.IO)
    }

    override suspend fun addMatchToFavorite(proMatches: ProMatches) {
        favoriteMatchesDao.insertProMatch(proMatches)
    }

    override suspend fun removeMatchFromFavorite(match: ProMatches) {
        Timber.d("${match.matchId} for sending to DB")
        // favoriteMatchesDao.removeFavorite()
        favoriteMatchesDao.delete(match)
    }

    override suspend fun isFavorited(matchId: Long): Boolean {
        Timber.d("$matchId")
        Timber.d("${favoriteMatchesDao.isFavorited(matchId)}")
        return true
    }


    override fun fetchMatchDetails(matchId: Long): Flow<Resource<MatchDetails>> =
        steamDataSourceImpl.fetchMatchDetails(matchId)


    override fun fetchTeamLogo(ugcId: Long): Flow<Resource<TeamLogo>> =
        steamDataSourceImpl.fetchTeamLogo(ugcId)

    override fun fetchProMatches(): Flow<Resource<List<ProMatches>>> =
        openDotaDataSourceImpl.fetchProMatches()

    override fun fetchHeroes(): Flow<Resource<Heroes>> = openDotaDataSourceImpl.fetchHeroes()

    override fun fetchPlayer(playerIds: List<Player>): Flow<Resource<PlayerInfo>> =
        openDotaDataSourceImpl.fetchPlayer(playerIds)


}

