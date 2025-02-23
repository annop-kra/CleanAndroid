package com.ankn.cleanandroidtemplate

import android.app.Application
import com.ankn.cleanandroidtemplate.di.navigationModule
import com.ankn.core.di.CoreConfig
import com.ankn.cleanandroidtemplate.di.presentationModule
import com.ankn.cleanandroidtemplate.di.viewModelModule
import com.ankn.core.di.dataModule
import com.ankn.core.di.domainModule
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class CleanAndroidTemplateApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CleanAndroidTemplateApplication)
            modules(
                dataModule, domainModule, presentationModule, navigationModule,
                viewModelModule
            )
            val baseUrl = BuildConfig.BASE_URL
            val coreConfig = CoreConfig(baseUrl)
            getKoin().declare(coreConfig)
        }
    }
}