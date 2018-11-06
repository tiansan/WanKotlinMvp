package com.wankotlin.mvp.ui.login.presenter

import com.wankotlin.mvp.ui.base.presenter.MVPPresenter
import com.wankotlin.mvp.ui.login.interactor.LoginMVPInteractor
import com.wankotlin.mvp.ui.login.view.LoginMVPView

/**
 * Created by jyotidubey on 04/01/18.
 */
interface LoginMVPPresenter<V : LoginMVPView, I : LoginMVPInteractor> : MVPPresenter<V, I> {

    fun login(userName: String, password: String)

    fun register(userName: String, password: String, rePassword: String)

}