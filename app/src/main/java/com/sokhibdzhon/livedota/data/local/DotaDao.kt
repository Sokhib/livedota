package com.sokhibdzhon.livedota.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
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
abstract class DotaDao {
    @Query("SELECT * FROM pro_matches")
    abstract fun getProMatches(): Flow<List<ProMatches>>

    @Insert
    abstract fun insertProMatch(proMatch: ProMatches)

    @Query("SELECT * FROM PRO_MATCHES WHERE radiantName=:radiantName AND direName=:direName")
    abstract fun getMatchByTeamsName(radiantName: String?, direName: String?): ProMatches

    @Query("UPDATE pro_matches SET radiantSeriesScore = radiantSeriesScore + 1 WHERE radiantName=:radiantName AND direName=:direName")
    abstract fun updateRadiantScore(radiantName: String?, direName: String?)

    @Query("UPDATE pro_matches SET direSeriesScore = direSeriesScore + 1 WHERE radiantName=:radiantName AND direName=:direName")
    abstract fun updateDireScore(radiantName: String?, direName: String?)

}