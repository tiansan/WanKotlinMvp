package com.wankotlin.mvp.ui.home.presenter

import com.wankotlin.mvp.ui.base.presenter.MVPPresenter
import com.wankotlin.mvp.ui.home.interactor.HomeMVPInteractor
import com.wankotlin.mvp.ui.home.view.HomeMVPView

interface HomeMVPPresenter<V : HomeMVPView, I : HomeMVPInteractor> : MVPPresenter<V, I> {

    fun getHomeArticles(page: String)

    fun getHomeBanner()
}