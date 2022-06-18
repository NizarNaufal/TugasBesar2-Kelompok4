package com.kelompok4.tugasbesar2.ui

import android.app.Application
import com.kelompok4.core.di.apiModule
import com.kelompok4.core.di.databaseModule
import com.kelompok4.core.di.repositoryModule
import com.kelompok4.tugasbesar2.di.useCaseModule
import com.kelompok4.tugasbesar2.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Games : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@Games)
            modules(
                listOf(
                    databaseModule,
                    apiModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}