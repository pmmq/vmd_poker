package com.pmmq.vmd_poker.ui.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import com.pmmq.vmd_poker.R
import com.pmmq.vmd_poker.databinding.ActivityMainBinding
import com.pmmq.vmd_poker.di.component.ApplicationComponent
import com.pmmq.vmd_poker.ui.PokerApplication
import com.pmmq.vmd_poker.ui.base.BaseActivity
import javax.inject.Inject
import android.arch.lifecycle.ViewModelProviders



class MainActivity : BaseActivity<ActivityMainBinding>() {

    @Inject
    protected lateinit var currApp : PokerApplication
    protected lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = MainViewModel.create(this)
        mainViewModel.dataBinding = dataBinding as ActivityMainBinding
        mainViewModel.bind()
    }

    override fun getLayouteRes(): Int {
        return R.layout.activity_main;
    }

    override fun injectComponent(appComponent: ApplicationComponent?) {
        appComponent?.inject(this)
    }
}
