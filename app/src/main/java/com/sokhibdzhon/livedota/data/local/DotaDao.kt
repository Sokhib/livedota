package com.sokhibdzhon.livedota.data.local

import androidx.room.*
import com.sokhibdzhon.livedota.data.local.entity.ProMatches
import kotlinx.coroutines.flow.Flow


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */
@Dao
abstract class FavoriteMatchesDao {
    @Query("SELECT * FROM pro_matches")
    abstract fun getProMatches(): Flow<List<ProMatches>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertProMatch(proMatch: ProMatches)

    @Delete
    abstract suspend fun delete(match: ProMatches)

    @Query("DELETE FROM pro_matches")
    abstract suspend fun removeFavorite()

    @Query("SELECT isFavorited FROM pro_matches WHERE matchId = :matchId")
    abstract suspend fun isFavorited(matchId: Long): Boolean

}