package com.wankotlin.mvp.ui.splash

import com.wankotlin.mvp.ui.splash.interactor.SplashInteractor
import com.wankotlin.mvp.ui.splash.interactor.SplashMVPInteractor
import com.wankotlin.mvp.ui.splash.presenter.SplashMVPPresenter
import com.wankotlin.mvp.ui.splash.presenter.SplashPresenter
import com.wankotlin.mvp.ui.splash.view.SplashMVPView
import dagger.Module
import dagger.Provides

/**
 * Created by jyotidubey on 06/01/18.
 */
@Module
class SplashActivityModule {

    @Provides
    internal fun provideSplashInteractor(splashInteractor: SplashInteractor): SplashMVPInteractor = splashInteractor

    @Provides
    internal fun provideSplashPresenter(splashPresenter: SplashPresenter<SplashMVPView, SplashMVPInteractor>)
            : SplashMVPPresenter<SplashMVPView, SplashMVPInteractor> = splashPresenter
}