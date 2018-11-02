package com.wankotlin.mvp.ui.base.interactor

import com.wankotlin.mvp.data.network.ApiHelper
import com.wankotlin.mvp.data.network.model.User
import com.wankotlin.mvp.data.preferences.PreferenceHelper
import com.wankotlin.mvp.util.AppConstants


/**
 * Created by jyotidubey on 04/01/18.
 */
open class BaseInteractor() : MVPInteractor {

    protected lateinit var preferenceHelper: PreferenceHelper
    protected lateinit var apiHelper: ApiHelper

    constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : this() {
        this.preferenceHelper = preferenceHelper
        this.apiHelper = apiHelper
    }

    override fun isUserLoggedIn() = this.preferenceHelper.getCurrentUserLoggedInMode() != AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type

    override fun performUserLogout() = preferenceHelper.let {
        it.setCurrentUserId(null)
        it.setAccessToken(null)
        it.setCurrentUserEmail(null)
        it.setAccessToken(null)
        it.setCurrentUserIcon(null)
        it.setCurrentUserPassword(null)
        it.setCurrnetUserType(-1)
        it.setCurrentUserLoggedInMode(AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT)
    }

    override fun getUserInfo(): User {
        var user = User()
        preferenceHelper.let {
            user.email = it.getCurrentUserEmail()
            user.icon = it.getCurrentUserIcon()
            user.id = it.getCurrentUserId()
            user.password = it.getCurrentUserPassword()
            user.token = it.getAccessToken()
            user.type = it.getCurrentUserType()
            user.username = it.getCurrentUserName()
        }
        return user
    }

}