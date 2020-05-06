package com.sokhibdzhon.livedota.data.network.opendota

import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.network.model.ProMatches
import com.sokhibdzhon.livedota.data.network.model.heroes.Heroes
import com.sokhibdzhon.livedota.data.network.model.matchdetails.Player
import com.sokhibdzhon.livedota.data.network.model.matchdetails.PlayerInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import timber.log.Timber
import javax.inject.Inject


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */


class OpenDotaDataSourceImpl @Inject constructor(private val openDotaApiService: OpenDotaApiService) :
    OpenDotaDataSource {
    //TODO: try map, filter, drop, combine, flowOn, onCompletion here before emitting
    override fun fetchProMatches(): Flow<Resource<List<ProMatches>>> = flow {
        emit(Resource.loading())
        try {
            val proMatches = openDotaApiService.getProMatches()
            emit(Resource.success(proMatches))
        } catch (exception: Exception) {
            Timber.d("$exception")
            emit(Resource.error<List<ProMatches>>(exception.message ?: "Error loading Pro Matches"))
        }

    }
//    do series score combiner here :)
//        .map {
//        it
//    }.flowOn(Dispatchers.Default)

    override fun fetchHeroes(): Flow<Resource<Heroes>> = flow {
        Timber.d("Fetching Heroes...")
        emit(Resource.loading())
        try {
            val heroes = openDotaApiService.getHeroes()
            emit(Resource.success(heroes))
        } catch (exception: Exception) {
            Timber.d("$exception")
            emit(Resource.error<Heroes>(exception.message ?: "Error loading Pro Matches"))
        }
    }

    @FlowPreview
    override fun fetchPlayer(accounts: List<Player>): Flow<Resource<PlayerInfo>> = flow {

        try {
            val players = accounts.asFlow().flatMapMerge(concurrency = 1) { player ->
                flow {
                    val res = openDotaApiService.getPlayer(player.accountId)
                    emit(Resource.success(res))
                }
            }.flowOn(Dispatchers.IO)

            players.collect {
                emit(it)
            }

        } catch (exception: Exception) {
            Timber.d("$exception")
        }
    }

}
