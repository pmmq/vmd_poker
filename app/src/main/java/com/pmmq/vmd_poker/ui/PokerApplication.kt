package com.pmmq.vmd_poker.ui

import android.app.Application
import com.pmmq.vmd_poker.di.component.DaggerApplicationComponent
import com.pmmq.vmd_poker.di.module.ApplicationModule


class PokerApplication : Application() {

    val component by lazy {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}