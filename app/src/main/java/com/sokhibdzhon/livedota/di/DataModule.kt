package com.sokhibdzhon.livedota.di

import android.content.Context
import androidx.room.Room
import com.sokhibdzhon.livedota.data.local.DotaDao
import com.sokhibdzhon.livedota.data.local.DotaDatabase
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
    //Use it to get Repository, local database, dao and remote dataSource object if needed
    @Provides
    fun provideDatabase(context: Context): DotaDatabase =
        Room.databaseBuilder(context, DotaDatabase::class.java, "dota-database").build()


    @Provides
    fun provideDotaDao(database: DotaDatabase): DotaDao = database.getDotaDao()

}