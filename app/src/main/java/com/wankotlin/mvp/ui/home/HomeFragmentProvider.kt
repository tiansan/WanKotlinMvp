package com.wankotlin.mvp.ui.home

import com.wankotlin.mvp.ui.home.view.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
internal abstract class HomeFragmentProvider {

    @ContributesAndroidInjector(modules = [(HomeFragmentModule::class)])
    internal abstract fun providerHomeFragmentFactory(): HomeFragment

}