package com.sokhibdzhon.livedota.buildsrc


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

object Classpaths {
    val gradleClasspath = "com.android.tools.build:gradle:${Versions.gradleVersion}"
    val kotlinGradleClasspath =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    val navigationSafeArgsClasspath =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navVersion}"
}