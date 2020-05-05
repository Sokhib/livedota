package com.sokhibdzhon.livedota.data.network.opendota

import com.sokhibdzhon.livedota.data.network.model.ProMatches
import com.sokhibdzhon.livedota.data.network.model.heroes.Heroes
import com.sokhibdzhon.livedota.data.network.model.matchdetails.PlayerInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface OpenDotaApiService {

    @GET("proMatches")
    suspend fun getProMatches(): List<ProMatches>

    @GET("heroes")
    suspend fun getHeroes(): Heroes

    @GET("players/{accountId}")
    suspend fun getPlayer(@Path("accountId") accountId: Long): PlayerInfo
}
