package com.wankotlin.mvp.ui.splash.presenter

import com.wankotlin.mvp.ui.base.presenter.MVPPresenter
import com.wankotlin.mvp.ui.splash.interactor.SplashMVPInteractor
import com.wankotlin.mvp.ui.splash.view.SplashMVPView

/**
 * Created by jyotidubey on 04/01/18.
 */
interface SplashMVPPresenter<V : SplashMVPView, I : SplashMVPInteractor> : MVPPresenter<V, I>