package com.sokhibdzhon.livedota.di

import androidx.annotation.NonNull
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sokhibdzhon.livedota.BuildConfig
import com.sokhibdzhon.livedota.data.network.OpenDotaApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov  ║
╠══════════════════════════════════════╣
║ sokhibsaid@gmail.com                ║
╚═════════════════════════════════════╝
 */

@Module
class NetworkModule {
    @Singleton
    @Provides
    @NonNull
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(provideGsonConvertorFactory())
        .baseUrl(provideOpenDotaServerUrl())
        .build()

    fun provideOpenDotaApiService(retrofit: Retrofit): OpenDotaApiService =
        retrofit.create(OpenDotaApiService::class.java)

    private fun provideGsonConvertorFactory(): GsonConverterFactory =
        GsonConverterFactory.create(provideGson())

    private fun provideGson(): Gson = GsonBuilder().create()

    private fun provideOpenDotaServerUrl() = BuildConfig.SERVER_URL
}