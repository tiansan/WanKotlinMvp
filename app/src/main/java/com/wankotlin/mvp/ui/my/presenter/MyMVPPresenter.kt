package com.wankotlin.mvp.ui.my.presenter

import com.wankotlin.mvp.ui.base.presenter.MVPPresenter
import com.wankotlin.mvp.ui.my.interactor.MyMVPInteractor
import com.wankotlin.mvp.ui.my.view.MyMVPView

interface MyMVPPresenter<V : MyMVPView, I : MyMVPInteractor> : MVPPresenter<V, I> {

    fun doLogout()

}