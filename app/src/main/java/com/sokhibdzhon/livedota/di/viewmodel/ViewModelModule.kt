package com.sokhibdzhon.livedota.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sokhibdzhon.livedota.ui.matchdetails.MatchDetailsViewModel
import com.sokhibdzhon.livedota.ui.matches.MatchesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelMapKey(MatchesViewModel::class)
    internal abstract fun bindMatchesViewModel(viewModel: MatchesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelMapKey(MatchDetailsViewModel::class)
    internal abstract fun bindMatchDetailsViewModel(viewModel: MatchDetailsViewModel): ViewModel
}