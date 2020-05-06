package com.sokhibdzhon.livedota.data.network.opendota

import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.network.model.ProMatches
import com.sokhibdzhon.livedota.data.network.model.heroes.Heroes
import com.sokhibdzhon.livedota.data.network.model.matchdetails.Player
import com.sokhibdzhon.livedota.data.network.model.matchdetails.PlayerInfo
import kotlinx.coroutines.flow.Flow


interface OpenDotaDataSource {

    fun fetchProMatches(): Flow<Resource<List<ProMatches>>>
    fun fetchHeroes(): Flow<Resource<Heroes>>
    fun fetchPlayer(accountIds: List<Player>): Flow<Resource<PlayerInfo>>

}