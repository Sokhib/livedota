package com.sokhibdzhon.livedota.base

import android.app.Application
import com.sokhibdzhon.livedota.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov  ║
╠══════════════════════════════════════╣
║ sokhibsaid@gmail.com                ║
╚═════════════════════════════════════╝
 */
@HiltAndroidApp
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }
}