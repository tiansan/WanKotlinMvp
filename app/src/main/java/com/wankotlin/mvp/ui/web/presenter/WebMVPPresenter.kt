package com.wankotlin.mvp.ui.web.presenter

import com.wankotlin.mvp.ui.base.presenter.MVPPresenter
import com.wankotlin.mvp.ui.web.interactor.WebMVPInteractor
import com.wankotlin.mvp.ui.web.view.WebMVPView

/**
 * Created by jyotidubey on 04/01/18.
 */
interface WebMVPPresenter<V : WebMVPView, I : WebMVPInteractor> : MVPPresenter<V, I>{

    fun decideActivityToOpen(collect: Boolean, originId: Int, id: Int)

}