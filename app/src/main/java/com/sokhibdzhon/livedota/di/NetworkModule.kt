package com.sokhibdzhon.livedota.di

import androidx.annotation.NonNull
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sokhibdzhon.livedota.BuildConfig
import com.sokhibdzhon.livedota.data.network.opendota.OpenDotaApiService
import com.sokhibdzhon.livedota.data.network.steam.SteamApiService
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
//TODO: Ask what if my SERVER_URL changes?
@Module
class NetworkModule {
    @Singleton
    @Provides
    @NonNull
    fun provideRetrofit(): Retrofit.Builder = Retrofit.Builder()

    @Singleton
    @Provides
    @NonNull
    fun provideOpenDotaApiService(retrofitBuilder: Retrofit.Builder): OpenDotaApiService =
        retrofitBuilder.addConverterFactory(provideGsonConvertorFactory())
            .baseUrl(provideOpenDotaServerUrl())
            .build()
            .create(OpenDotaApiService::class.java)

    @Singleton
    @Provides
    @NonNull
    fun provideSteamApiService(retrofitBuilder: Retrofit.Builder): SteamApiService =
        retrofitBuilder.addConverterFactory(provideGsonConvertorFactory())
            .baseUrl(provideSteamServerUrl())
            .build()
            .create(SteamApiService::class.java)

    private fun provideGsonConvertorFactory(): GsonConverterFactory =
        GsonConverterFactory.create(provideGson())

    private fun provideGson(): Gson = GsonBuilder().create()

    private fun provideOpenDotaServerUrl() = BuildConfig.SERVER_URL
    private fun provideSteamServerUrl() = BuildConfig.STEAM_URL
}