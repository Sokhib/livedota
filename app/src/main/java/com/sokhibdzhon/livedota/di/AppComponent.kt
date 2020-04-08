package com.sokhibdzhon.livedota.di

import com.sokhibdzhon.livedota.di.viewmodel.ViewModelModule
import com.sokhibdzhon.livedota.ui.matches.MatchesFragment
import com.sokhibdzhon.livedota.ui.matches.di.MatchesFragmentModule
import dagger.Component
import javax.inject.Singleton


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov  ║
╠══════════════════════════════════════╣
║ sokhibsaid@gmail.com                ║
╚═════════════════════════════════════╝
 */
@Singleton
@Component(
    modules = [NetworkModule::class,
        ViewModelModule::class,
        MatchesFragmentModule::class]
)
interface AppComponent {
//    @Component.Factory
//    interface Factory {
//        fun create(@BindsInstance context: Context): AppComponent
//    }

    fun inject(matchesFragment: MatchesFragment)

}