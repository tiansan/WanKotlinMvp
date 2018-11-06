package com.wankotlin.mvp.di.builder

import com.wankotlin.mvp.ui.home.HomeFragmentProvider
import com.wankotlin.mvp.ui.login.LoginActivityModule
import com.wankotlin.mvp.ui.login.view.LoginActivity
import com.wankotlin.mvp.ui.main.MainActivityModule
import com.wankotlin.mvp.ui.main.view.MainActivity
import com.wankotlin.mvp.ui.my.MyFragmentProvider
import com.wankotlin.mvp.ui.splash.SplashActivityModule
import com.wankotlin.mvp.ui.splash.view.SplashActivity
import com.wankotlin.mvp.ui.web.WebActivityModule
import com.wankotlin.mvp.ui.web.view.WebActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by jyotidubey on 05/01/18.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(SplashActivityModule::class)])
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [(MainActivityModule::class), (HomeFragmentProvider::class), (MyFragmentProvider::class)])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [(WebActivityModule::class)])
    abstract fun bindWebActivity(): WebActivity

    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    abstract fun bindLoginActivity(): LoginActivity
}