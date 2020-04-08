package com.sokhibdzhon.livedota.data.network

import com.sokhibdzhon.livedota.data.network.model.ProMatches
import retrofit2.http.GET

interface OpenDotaApiService {

    // Get pro matches...
    @GET("proMatches")
    suspend fun getProMatches(): List<ProMatches>

}
