package com.sokhibdzhon.livedota.ui.common.di

import com.sokhibdzhon.livedota.ui.common.MatchesAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */
@InstallIn(FragmentComponent::class)
@Module
class MatchesFragmentModule {
    @Provides
    fun provideMatchesAdapter(): MatchesAdapter {
        return MatchesAdapter()
    }
}