package com.sokhibdzhon.livedota.ui.matchdetails

import android.view.View
import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.Status
import com.sokhibdzhon.livedota.data.network.model.matchdetails.MatchDetails
import com.sokhibdzhon.livedota.data.network.model.matchdetails.PicksBan


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

data class MatchDetailsViewState(val matchDetailsResource: Resource<MatchDetails>?) {
    private val radiantBans: MutableList<PicksBan> = ArrayList()
    private val radiantPicks: MutableList<PicksBan> = ArrayList()
    private val direBans: MutableList<PicksBan> = ArrayList()
    private val direPicks: MutableList<PicksBan> = ArrayList()

    init {
        matchDetailsResource!!.data?.picksBans!!.forEach {
            if (it.team == 0) {
                if (it.isPick) radiantPicks.add(it) else radiantBans.add(it)
            } else {
                if (it.isPick) direPicks.add(it) else direBans.add(it)
            }
        }
    }


    fun getProgressBarVisibility(): Int {
        return when (matchDetailsResource!!.status) {
            Status.LOADING -> View.VISIBLE
            else -> View.GONE
        }
    }

    fun getLeagueName(): String = matchDetailsResource!!.data?.league?.name ?: ""
    fun getRadiantScore(): Int = matchDetailsResource!!.data?.radiantScore ?: 0
    fun getDireScore(): Int = matchDetailsResource!!.data?.direScore ?: 0
    fun getRadiantSeriesScore(): Int = if (matchDetailsResource!!.data?.radiantWin!!) 1 else 0
    fun getDireSeriesScore(): Int = if (matchDetailsResource!!.data?.radiantWin!!) 0 else 1

    fun getRadiantTeamName(): String =
        matchDetailsResource!!.data?.radiantTeam?.name ?: "Radiant Team"

    fun getDireTeamName(): String = matchDetailsResource!!.data?.direTeam?.name ?: "Dire Team"
    fun getPlayer(playerPosition: Int): String =
        matchDetailsResource!!.data?.players?.get(playerPosition - 1)?.name
            ?: "$playerPosition position player "

    fun getRadiantPick(position: Int): Int = radiantPicks[position - 1].heroId
    fun getDirePick(position: Int): Int = direPicks[position - 1].heroId
    fun getRadiantBan(position: Int): Int = radiantBans[position - 1].heroId
    fun getDireBan(position: Int): Int = direBans[position - 1].heroId

}

