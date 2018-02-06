package com.pmmq.vmd_poker.ui.base

import android.databinding.ViewDataBinding
import android.support.v7.app.AppCompatActivity
import android.support.annotation.LayoutRes
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.pmmq.vmd_poker.di.component.ApplicationComponent
import com.pmmq.vmd_poker.ui.PokerApplication
import com.pmmq.vmd_poker.ui.main.MainActivity


abstract class BaseActivity<DB : ViewDataBinding> : AppCompatActivity() {
    var dataBinding: DB? = null
    @LayoutRes
    abstract fun getLayouteRes(): Int
    abstract fun injectComponent(appComponent: ApplicationComponent?)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectComponent((application as? PokerApplication)?.component);
        dataBinding = DataBindingUtil.setContentView(this, getLayouteRes())
    }

}