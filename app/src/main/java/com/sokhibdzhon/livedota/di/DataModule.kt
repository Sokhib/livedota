package com.sokhibdzhon.livedota.di

import com.sokhibdzhon.livedota.data.local.FavoriteMatchesDao
import com.sokhibdzhon.livedota.data.network.opendota.OpenDotaDataSourceImpl
import com.sokhibdzhon.livedota.data.network.steam.SteamDataSourceImpl
import com.sokhibdzhon.livedota.data.repository.DotaRepositoryImpl
import com.sokhibdzhon.livedota.data.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

@InstallIn(ActivityComponent::class)
@Module(includes = [DatabaseModule::class, NetworkModule::class])
class DataModule {
    @Provides
    fun provideRepository(
        steamDataSourceImpl: SteamDataSourceImpl,
        openDotaDataSourceImpl: OpenDotaDataSourceImpl,
        favoriteMatchesDao: FavoriteMatchesDao
    ): Repository =
        DotaRepositoryImpl(steamDataSourceImpl, openDotaDataSourceImpl, favoriteMatchesDao)

}