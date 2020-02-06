package com.sokhibdzhon.livedota.data.network

import com.sokhibdzhon.livedota.BuildConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class OpenDotaApiServiceProvider {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(BuildConfig.SERVER_URL)
        .build()
    private val apiService = retrofit.create(OpenDotaApiService::class.java)

    fun getOpenDotaApiService(): OpenDotaApiService = apiService


}

