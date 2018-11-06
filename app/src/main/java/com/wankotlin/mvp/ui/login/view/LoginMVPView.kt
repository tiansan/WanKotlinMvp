package com.wankotlin.mvp.ui.login.view

import com.wankotlin.mvp.data.network.model.User
import com.wankotlin.mvp.ui.base.view.MVPView


/**
 * Created by jyotidubey on 04/01/18.
 */
interface LoginMVPView : MVPView {

    fun onLoginSuccess(user: User)

    fun onLoginFailed(msg: String)

    fun onRegisterSuccess(user: User)

    fun onRegisterFailed(msg: String)

}