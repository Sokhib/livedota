package com.sokhibdzhon.livedota.di

import androidx.annotation.NonNull
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sokhibdzhon.livedota.BuildConfig
import com.sokhibdzhon.livedota.data.network.opendota.OpenDotaApiService
import com.sokhibdzhon.livedota.data.network.steam.SteamApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
    fun provideRetrofit(): Retrofit.Builder = Retrofit.Builder()

    @Singleton
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

    @Singleton
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
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        return httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }
}