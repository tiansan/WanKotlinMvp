package com.wankotlin.mvp.ui.base.presenter

import com.wankotlin.mvp.ui.base.interactor.MVPInteractor
import com.wankotlin.mvp.ui.base.view.MVPView


/**
 * Created by jyotidubey on 04/01/18.
 */
interface MVPPresenter<V : MVPView, I : MVPInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

    fun isUserLoggedIn(): Boolean

}