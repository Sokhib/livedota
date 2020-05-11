package com.sokhibdzhon.livedota.di

import android.content.Context
import androidx.room.Room
import com.sokhibdzhon.livedota.data.local.DotaDatabase
import com.sokhibdzhon.livedota.data.local.FavoriteMatchesDao
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
class DatabaseModule {
    @Provides
    fun provideDatabase(context: Context): DotaDatabase =
        Room.databaseBuilder(context, DotaDatabase::class.java, "dota-database").build()


    @Provides
    fun provideFavoriteMatchesDao(database: DotaDatabase): FavoriteMatchesDao =
        database.getFavoriteMatchesDao()

}