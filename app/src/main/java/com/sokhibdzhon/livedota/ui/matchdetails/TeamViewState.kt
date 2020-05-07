package com.sokhibdzhon.livedota.ui.matchdetails

import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.network.model.teamitem.TeamLogo
import com.sokhibdzhon.livedota.data.network.model.teamitem.getUrl


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

data class TeamViewState(val teamLogo: Resource<TeamLogo>) {

    fun getTeamUrl(): String =
        teamLogo.data?.getUrl() ?: ""
}