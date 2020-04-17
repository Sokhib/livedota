package com.sokhibdzhon.livedota

import android.app.Application
import com.sokhibdzhon.livedota.di.AppComponent
import com.sokhibdzhon.livedota.di.DaggerAppComponent
import timber.log.Timber


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov  ║
╠══════════════════════════════════════╣
║ sokhibsaid@gmail.com                ║
╚═════════════════════════════════════╝
 */

class BaseApplication : Application() {
    val appGraph: AppComponent = DaggerAppComponent.create()
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }
}