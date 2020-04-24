package com.sokhibdzhon.livedota.data.network.steam

import com.sokhibdzhon.livedota.data.network.model.matchdetails.MatchDetails
import retrofit2.http.GET
import retrofit2.http.Query


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

interface SteamApiService {

    @GET("GetMatchDetails/v1")
    suspend fun getMatchDetailsByMatchId(
        @Query("key") key: String = API_KEY,
        @Query("match_id") matchId: Long
    ): MatchDetails

    //TODO: Dogru mu degil mi?
    companion object {
        const val API_KEY = "CD46348331B9C662F4E8B22BF1977E0B"
    }
}