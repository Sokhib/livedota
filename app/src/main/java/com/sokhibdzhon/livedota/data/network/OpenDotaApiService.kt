package com.sokhibdzhon.livedota.data.network

import com.sokhibdzhon.livedota.data.network.model.MatchDetails
import com.sokhibdzhon.livedota.data.network.model.ProMatches
import retrofit2.http.GET
import retrofit2.http.Path

interface OpenDotaApiService {

    @GET("proMatches")
    suspend fun getProMatches(): List<ProMatches>

    @GET("matches/{match_id}}")
    suspend fun getMatchDetailsByMatchId(@Path("match_id") matchId: Long): MatchDetails

}
