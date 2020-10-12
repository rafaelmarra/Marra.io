package com.marraps.marraio

import android.app.Application
import com.marraps.api.koin.apiModules
import com.marraps.home_presentation.koin.homeModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MarraApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MarraApplication)
            modules(apiModules + homeModules)
        }
    }
}