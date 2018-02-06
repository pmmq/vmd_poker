package com.pmmq.vmd_poker.di.module

import android.content.Context
import android.content.SharedPreferences
import com.pmmq.vmd_poker.ui.PokerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by pmmq on 2/5/2018.
 */

@Module
class ApplicationModule(var app: PokerApplication) {

    @Provides
    @Singleton
    fun provideApp(): PokerApplication = app

    @Provides
    @Singleton
    fun provideContext(): Context = app.applicationContext
}