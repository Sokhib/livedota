package com.sokhibdzhon.livedota.ui.matchdetails

import android.view.View
import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.network.model.matchdetails.PlayerInfo


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

data class PlayerViewState(val playerResource: List<Resource<PlayerInfo>>) {

    fun getPlayer(playerPosition: Int): String =
        playerResource[playerPosition - 1].data?.profile?.name
            ?: playerResource[playerPosition - 1].data?.profile?.personaname
            ?: "Player $playerPosition"

    fun getProgressBarVisibility(): Int {
        return when (playerResource.size) {
            10 -> View.GONE
            else -> View.VISIBLE
        }
    }
}

