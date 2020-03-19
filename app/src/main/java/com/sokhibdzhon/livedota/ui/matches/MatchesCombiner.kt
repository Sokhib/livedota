package com.sokhibdzhon.livedota.ui.matches

import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.network.model.ProMatches


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */
//TODO: Later check team names and combine same games AND ALSO get team logo ??
fun combineMatches(proMatches: Resource<List<ProMatches>>): MatchesFragmentViewState {
    return MatchesFragmentViewState(proMatches)
}
