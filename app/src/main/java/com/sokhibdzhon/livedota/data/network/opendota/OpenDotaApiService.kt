package com.sokhibdzhon.livedota.data.network.opendota

import com.sokhibdzhon.livedota.data.network.model.ProMatches
import retrofit2.http.GET

interface OpenDotaApiService {

    @GET("proMatches")
    suspend fun getProMatches(): List<ProMatches>

}
