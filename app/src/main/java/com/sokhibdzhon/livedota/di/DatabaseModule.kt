package com.sokhibdzhon.livedota.di

import android.content.Context
import androidx.room.Room
import com.sokhibdzhon.livedota.data.local.DotaDatabase
import com.sokhibdzhon.livedota.data.local.FavoriteMatchesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov  ║
╠══════════════════════════════════════╣
║ sokhibsaid@gmail.com                ║
╚═════════════════════════════════════╝
 */

@Module
@InstallIn(ActivityComponent::class)
class DatabaseModule {
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): DotaDatabase =
        Room.databaseBuilder(context, DotaDatabase::class.java, "dota-database").build()


    @Provides
    fun provideFavoriteMatchesDao(database: DotaDatabase): FavoriteMatchesDao =
        database.getFavoriteMatchesDao()

}