package com.wankotlin.mvp.ui.login.view

import com.wankotlin.mvp.ui.base.view.MVPView


/**
 * Created by jyotidubey on 04/01/18.
 */
interface LoginMVPView : MVPView {

    fun onLoginSuccess()

    fun onLoginFailed(msg: String)

    fun onRegisterSuccess()

    fun onRegisterFailed(msg: String)

}