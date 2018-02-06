package com.pmmq.vmd_poker.di.component

import android.app.Application
import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.pmmq.vmd_poker.di.module.ApplicationModule
import com.pmmq.vmd_poker.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by pmmq on 2/5/2018.
 */

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(application: AppCompatActivity)
    fun inject(mainActivity: MainActivity)
}