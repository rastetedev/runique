package com.raulastete.runique

import android.app.Application
import com.raulastete.auth.data.di.authDataModule
import com.raulastete.auth.presentation.di.authViewModelModule
import com.raulastete.core.data.networking.di.coreDataModule
import com.raulastete.run.location.di.locationModule
import com.raulastete.run.presentation.di.runPresentationModule
import com.raulastete.runique.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule,
                runPresentationModule,
                locationModule
            )
        }
    }
}