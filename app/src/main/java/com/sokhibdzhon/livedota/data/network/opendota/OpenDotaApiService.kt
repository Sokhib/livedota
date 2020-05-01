package com.sokhibdzhon.livedota.data.network.opendota

import com.sokhibdzhon.livedota.data.network.model.ProMatches
import com.sokhibdzhon.livedota.data.network.model.heroes.Heroes
import retrofit2.http.GET

interface OpenDotaApiService {

    @GET("proMatches")
    suspend fun getProMatches(): List<ProMatches>

    @GET("heroes")
    suspend fun getHeroes(): Heroes

}
