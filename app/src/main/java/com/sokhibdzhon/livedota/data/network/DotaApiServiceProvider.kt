package com.sokhibdzhon.livedota.data.network

import retrofit2.Retrofit
import javax.inject.Inject

//TODO: What if make it singleton, right choice?
class DotaApiServiceProvider @Inject constructor(retrofit: Retrofit) {
//TODO: What is the problem with field injection.
//    @Inject
//    lateinit var retrofit:Retrofit

    val openDotaApiService: OpenDotaApiService = retrofit.create(OpenDotaApiService::class.java)

}

