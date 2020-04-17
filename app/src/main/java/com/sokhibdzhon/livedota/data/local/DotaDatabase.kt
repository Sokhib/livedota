package com.sokhibdzhon.livedota.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sokhibdzhon.livedota.data.local.entity.ProMatches


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */


@Database(entities = [ProMatches::class], version = 1, exportSchema = false)

abstract class DotaDatabase : RoomDatabase() {
    abstract fun getDotaDao(): DotaDao
}