package com.sokhibdzhon.livedota.di

import android.content.Context
import com.sokhibdzhon.livedota.di.viewmodel.ViewModelModule
import com.sokhibdzhon.livedota.ui.common.di.MatchesFragmentModule
import com.sokhibdzhon.livedota.ui.favorites.FavoritesFragment
import com.sokhibdzhon.livedota.ui.matchdetails.MatchDetailsFragment
import com.sokhibdzhon.livedota.ui.matches.MatchesFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov  ║
╠══════════════════════════════════════╣
║ sokhibsaid@gmail.com                ║
╚═════════════════════════════════════╝
 */
//TODO: MatchesFragmentModule'u ayri subcomponent'e almak mi lazim?
@Singleton
@Component(
    modules = [DataModule::class,
        ViewModelModule::class,
        MatchesFragmentModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(matchesFragment: MatchesFragment)
    fun inject(matchDetailsFragment: MatchDetailsFragment)
    fun inject(favoritesFragment: FavoritesFragment)

}