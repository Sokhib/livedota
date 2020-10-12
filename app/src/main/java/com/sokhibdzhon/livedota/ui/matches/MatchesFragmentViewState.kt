package com.sokhibdzhon.livedota.ui.matches

import android.view.View
import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.Status
import com.sokhibdzhon.livedota.data.local.entity.ProMatches
import com.sokhibdzhon.livedota.ui.common.MatchesViewState


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

data class MatchesFragmentViewState(private val proMatchesResource: Resource<List<ProMatches>>) :
    MatchesViewState(proMatchesResource) {

    override fun getProMatchesProgressBarVisibility(): Int {
        return when (proMatchesResource.status) {
            Status.LOADING -> View.VISIBLE
            else -> View.GONE
        }
    }

    override fun getTextViewErrorVisibility(): Int {
        return when (proMatchesResource.status) {
            Status.ERROR -> View.VISIBLE
            else -> View.GONE
        }
    }

    override fun getTextViewErrorText(): String? {
        if (proMatchesResource.status == Status.ERROR) {
            return proMatchesResource.message ?: "Error"
        }
        return "ERROR"
    }
}