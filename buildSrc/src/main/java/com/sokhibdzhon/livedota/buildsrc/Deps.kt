package com.sokhibdzhon.livedota.buildsrc

object Deps {
    val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompatVersion}"
    val ktxCore = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    val junit = "junit:junit:${Versions.junitVersion}"
    val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacySupportV4Version}"
    val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    val lifecycleExtension = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleVersion}"
    val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycleVersion}"
    val lifecycleRuntimeKtx =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
    val material = "com.google.android.material:material:${Versions.materialVersion}"
    val testJUnit = "androidx.test.ext:junit:${Versions.androidXTestJUnitVersion}"
    val navigationKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
    val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    val retrofitGsonConverter =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptorVersion}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
    val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    val espressoCore =
        "androidx.test.espresso:espresso-core:${Versions.androidXTestEspressoCoreVersion}"
    val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutineVersion}"
    val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    val roomKtx = "androidx.room:room-ktx:${Versions.roomKtxVersion}"
    val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
    val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"

    val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"
    val debugDb = "com.amitshekhar.android:debug-db:${Versions.debugDbVersion}"

    val firebase = "com.google.firebase:firebase-analytics:${Versions.firebaseVersion}"
    val crashlytics = "com.google.firebase:firebase-crashlytics:${Versions.crashlyticsVersion}"
}