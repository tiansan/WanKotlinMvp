package com.wankotlin.mvp.ui.collect.presenter

import com.wankotlin.mvp.ui.base.presenter.MVPPresenter
import com.wankotlin.mvp.ui.collect.interactor.CollectMVPInteractor
import com.wankotlin.mvp.ui.collect.view.CollectMVPView

/**
 * Created by jyotidubey on 04/01/18.
 */
interface CollectMVPPresenter<V : CollectMVPView, I : CollectMVPInteractor> : MVPPresenter<V, I> {


}