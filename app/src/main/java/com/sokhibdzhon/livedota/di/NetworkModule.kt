package com.sokhibdzhon.livedota.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sokhibdzhon.livedota.BuildConfig
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
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(provideGsonConvertorFactory())
        .baseUrl(BuildConfig.SERVER_URL)
        .build()


    private fun provideGsonConvertorFactory(): GsonConverterFactory =
        GsonConverterFactory.create(provideGson())

    private fun provideGson(): Gson = GsonBuilder().create()
}