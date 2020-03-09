package com.sokhibdzhon.livedota.data.network

import com.sokhibdzhon.livedota.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class OpenDotaApiServiceProvider @Inject constructor() {

//    @Inject
//    lateinit var retrofit: Retrofit


    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.SERVER_URL)
        .build()
    val openDotaApiService: OpenDotaApiService = retrofit.create(OpenDotaApiService::class.java)


}

