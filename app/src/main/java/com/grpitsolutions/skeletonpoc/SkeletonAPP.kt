package com.grpitsolutions.skeletonpoc

import android.app.Application
import com.grpitsolutions.core.database.di.databaseModule
import com.grpitsolutions.skeletonpoc.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class SkeletonAPP: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SkeletonAPP)
            modules(
                databaseModule,
                appModule
            )
        }
    }
}