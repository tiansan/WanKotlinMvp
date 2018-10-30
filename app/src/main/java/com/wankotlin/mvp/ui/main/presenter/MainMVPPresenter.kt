package com.wankotlin.mvp.ui.main.presenter

import com.wankotlin.mvp.ui.base.presenter.MVPPresenter
import com.wankotlin.mvp.ui.main.interactor.MainMVPInteractor
import com.wankotlin.mvp.ui.main.view.MainMVPView

interface MainMVPPresenter<V : MainMVPView, I : MainMVPInteractor> : MVPPresenter<V, I> {
}