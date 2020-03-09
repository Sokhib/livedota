package com.sokhibdzhon.livedota.di

import com.sokhibdzhon.livedota.data.network.OpenDotaApiServiceProvider
import com.sokhibdzhon.livedota.data.network.OpenDotaDataSource
import com.sokhibdzhon.livedota.data.network.OpenDotaDataSourceImpl
import dagger.Module
import dagger.Provides


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov  ║
╠══════════════════════════════════════╣
║ sokhibsaid@gmail.com                ║
╚═════════════════════════════════════╝
 */

@Module
class DataModule {
    @Provides
    fun provideDataSource(): OpenDotaDataSource {
        return OpenDotaDataSourceImpl(provideDataSourceProvider())
    }

    @Provides
    fun provideDataSourceProvider(): OpenDotaApiServiceProvider {
        return OpenDotaApiServiceProvider()
    }

}