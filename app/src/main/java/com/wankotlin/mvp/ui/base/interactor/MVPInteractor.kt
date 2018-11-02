package com.wankotlin.mvp.ui.base.interactor

import com.wankotlin.mvp.data.network.model.User

/**
 * Created by jyotidubey on 04/01/18.
 */
interface MVPInteractor {

    fun isUserLoggedIn(): Boolean

    fun performUserLogout()

    fun getUserInfo(): User

}