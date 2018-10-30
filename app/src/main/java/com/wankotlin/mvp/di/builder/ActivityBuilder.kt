package com.wankotlin.mvp.di.builder

import com.wankotlin.mvp.ui.splash.SplashActivityModule
import com.wankotlin.mvp.ui.splash.view.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by jyotidubey on 05/01/18.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(SplashActivityModule::class)])
    abstract fun bindSplashActivity(): SplashActivity
//
//    @ContributesAndroidInjector(modules = [(MainActivityModule::class), (RateUsDialogFragmentProvider::class), (AboutFragmentProvider::class)])
//    abstract fun bindMainActivity(): MainActivity
//
//    @ContributesAndroidInjector(modules = [(LoginActivityModule::class)])
//    abstract fun bindLoginActivity(): LoginActivity
//
//    @ContributesAndroidInjector(modules = [(BlogFragmentProvider::class), (OpenSourceFragmentProvider::class)])
//    abstract fun bindFeedActivity(): FeedActivity

}