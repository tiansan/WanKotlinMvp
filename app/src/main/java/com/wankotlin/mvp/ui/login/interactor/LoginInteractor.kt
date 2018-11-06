package com.wankotlin.mvp.ui.login.interactor

import com.wankotlin.mvp.data.network.ApiHelper
import com.wankotlin.mvp.data.network.model.User
import com.wankotlin.mvp.data.network.model.UserResponse
import com.wankotlin.mvp.data.preferences.PreferenceHelper
import com.wankotlin.mvp.ui.base.interactor.BaseInteractor
import com.wankotlin.mvp.util.AppConstants
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by jyotidubey on 04/01/18.
 */
class LoginInteractor @Inject constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper), LoginMVPInteractor {

    override fun doUserLogin(userName: String, password: String) = apiHelper.doUserLogin(userName, password)

    override fun doUserRegister(userName: String, password: String, repassword: String): Observable<UserResponse> =
            apiHelper.doUserRegister(userName, password, repassword)

    override fun saveUserInfo(user: User) {
        user?.let {
            preferenceHelper.setCurrnetUserType(user.type)
            preferenceHelper.setCurrentUserPassword(user.password)
            preferenceHelper.setCurrentUserIcon(user.icon)
            preferenceHelper.setAccessToken(user.token)
            preferenceHelper.setCurrentUserEmail(user.email)
            preferenceHelper.setCurrentUserId(user.id)
            preferenceHelper.setCurrentUserName(user.username)
            preferenceHelper.setCurrentUserLoggedInMode(AppConstants.LoggedInMode.LOGGED_IN_MODE_SERVER)
        }
    }

}