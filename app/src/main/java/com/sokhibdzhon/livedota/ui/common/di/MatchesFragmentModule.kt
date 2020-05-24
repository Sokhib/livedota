package com.sokhibdzhon.livedota.ui.common.di

import com.sokhibdzhon.livedota.ui.matches.MatchesAdapter
import dagger.Module
import dagger.Provides


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */
@Module
class MatchesFragmentModule {
    @Provides
    fun provideMatchesAdapter(): MatchesAdapter {
        return MatchesAdapter()
    }
}