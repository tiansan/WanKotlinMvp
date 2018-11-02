package com.wankotlin.mvp.ui.my

import com.wankotlin.mvp.ui.my.view.MyFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
internal abstract class MyFragmentProvider {

    @ContributesAndroidInjector(modules = [(MyFragmentModule::class)])
    internal abstract fun providerMyFragmentFactory(): MyFragment

}