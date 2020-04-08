package com.sokhibdzhon.livedota.ui.matches

import android.view.View
import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.Status
import com.sokhibdzhon.livedota.data.network.model.ProMatches


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */
//TODO: Show error page/dialog when no internet connection.
data class MatchesFragmentViewState(private val proMatchesResource: Resource<List<ProMatches>>) {

    fun getProMatches() = proMatchesResource.data ?: arrayListOf()

    fun getProMatchesProgressBarVisibility(): Int {
        return when (proMatchesResource.status) {
            Status.LOADING -> View.VISIBLE
            else -> View.GONE
        }
    }
}