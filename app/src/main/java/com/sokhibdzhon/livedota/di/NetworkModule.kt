package com.sokhibdzhon.livedota.di

import androidx.annotation.NonNull
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sokhibdzhon.livedota.BuildConfig
import com.sokhibdzhon.livedota.data.network.opendota.OpenDotaApiService
import com.sokhibdzhon.livedota.data.network.opendota.OpenDotaDataSource
import com.sokhibdzhon.livedota.data.network.opendota.OpenDotaDataSourceImpl
import com.sokhibdzhon.livedota.data.network.steam.SteamApiService
import com.sokhibdzhon.livedota.data.network.steam.SteamDataSource
import com.sokhibdzhon.livedota.data.network.steam.SteamDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov  ║
╠══════════════════════════════════════╣
║ sokhibsaid@gmail.com                ║
╚═════════════════════════════════════╝
 */
@Module
@InstallIn(ActivityComponent::class)
class NetworkModule {
    @Provides
    @NonNull
    fun provideRetrofit(): Retrofit.Builder = Retrofit.Builder()

    @Provides
    @NonNull
    fun provideOpenDotaApiService(
        retrofitBuilder: Retrofit.Builder,
        okHttpClient: OkHttpClient
    ): OpenDotaApiService =
        retrofitBuilder.addConverterFactory(provideGsonConvertorFactory())
            .client(okHttpClient)
            .baseUrl(provideOpenDotaServerUrl())
            .build()
            .create(OpenDotaApiService::class.java)

    @Provides
    @NonNull
    fun provideSteamApiService(
        retrofitBuilder: Retrofit.Builder,
        okHttpClient: OkHttpClient
    ): SteamApiService =
        retrofitBuilder.addConverterFactory(provideGsonConvertorFactory())
            .client(okHttpClient)
            .baseUrl(provideSteamServerUrl())
            .build()
            .create(SteamApiService::class.java)

    private fun provideGsonConvertorFactory(): GsonConverterFactory =
        GsonConverterFactory.create(provideGson())

    private fun provideGson(): Gson = GsonBuilder().create()

    private fun provideOpenDotaServerUrl() = BuildConfig.SERVER_URL
    private fun provideSteamServerUrl() = BuildConfig.STEAM_URL

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        return httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    fun provideSteamDataSource(steamApiService: SteamApiService): SteamDataSource =
        SteamDataSourceImpl(steamApiService)


    @Provides
    fun provideOpenDotaDataSource(openDotaApiService: OpenDotaApiService): OpenDotaDataSource =
        OpenDotaDataSourceImpl(openDotaApiService)
}