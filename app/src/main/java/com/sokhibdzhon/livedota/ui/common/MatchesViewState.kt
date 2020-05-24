package com.sokhibdzhon.livedota.ui.common

import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.local.entity.ProMatches


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

abstract class MatchesViewState(private val proMatchesResource: Resource<List<ProMatches>>) {
    open fun getProMatches() = proMatchesResource.data ?: arrayListOf()

    abstract fun getProMatchesProgressBarVisibility(): Int
    abstract fun getTextViewErrorVisibility(): Int
    abstract fun getTextViewErrorText(): String?
}