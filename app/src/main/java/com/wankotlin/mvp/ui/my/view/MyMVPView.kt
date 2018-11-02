package com.wankotlin.mvp.ui.my.view

import com.wankotlin.mvp.data.network.model.User
import com.wankotlin.mvp.ui.base.view.MVPView

interface MyMVPView : MVPView {
    fun onLogoutSuccess()

    fun setViewLogout()

    fun setViewLogin(user: User?)
}