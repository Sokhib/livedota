package com.sokhibdzhon.livedota

import android.app.Application
import com.sokhibdzhon.livedota.di.AppComponent
import com.sokhibdzhon.livedota.di.DaggerAppComponent


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov  ║
╠══════════════════════════════════════╣
║ sokhibsaid@gmail.com                ║
╚═════════════════════════════════════╝
 */

class BaseApplication : Application() {
    val appGraph: AppComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }
}