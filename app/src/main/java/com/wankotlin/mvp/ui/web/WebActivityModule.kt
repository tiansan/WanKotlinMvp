package com.wankotlin.mvp.ui.web

import com.wankotlin.mvp.ui.web.interactor.WebInteractor
import com.wankotlin.mvp.ui.web.interactor.WebMVPInteractor
import com.wankotlin.mvp.ui.web.presenter.WebMVPPresenter
import com.wankotlin.mvp.ui.web.presenter.WebPresenter
import com.wankotlin.mvp.ui.web.view.WebMVPView
import dagger.Module
import dagger.Provides

/**
 * Created by jyotidubey on 06/01/18.
 */
@Module
class WebActivityModule {

    @Provides
    internal fun provideWebInteractor(webInteractor: WebInteractor): WebMVPInteractor = webInteractor

    @Provides
    internal fun provideWebPresenter(webPresenter: WebPresenter<WebMVPView, WebMVPInteractor>)
            : WebMVPPresenter<WebMVPView, WebMVPInteractor> = webPresenter
}