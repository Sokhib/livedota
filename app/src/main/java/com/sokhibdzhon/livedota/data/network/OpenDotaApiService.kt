package com.sokhibdzhon.livedota.data.network

import com.sokhibdzhon.livedota.data.network.model.ProMatches
import io.reactivex.Single
import retrofit2.http.GET

interface OpenDotaApiService {

    // Get pro matches...
    @GET("proMatches")
    fun getProMatches(): Single<List<ProMatches>>

}
