package com.ankn.cleanandroidtemplate

import android.app.Application
import com.ankn.core.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class CleanAndroidTemplateApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CleanAndroidTemplateApplication)
            modules(appModule)
        }
    }
}