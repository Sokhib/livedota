package com.sokhibdzhon.livedota.di

import android.content.Context
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
@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(matchesFragment: MatchesFragment)

}