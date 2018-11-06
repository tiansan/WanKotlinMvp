package com.wankotlin.mvp.ui.login.interactor

import com.wankotlin.mvp.data.network.model.User
import com.wankotlin.mvp.data.network.model.UserResponse
import com.wankotlin.mvp.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

/**
 * Created by jyotidubey on 04/01/18.
 */
interface LoginMVPInteractor : MVPInteractor {

    fun doUserLogin(userName: String, password: String): Observable<UserResponse>

    fun doUserRegister(userName: String, password: String, repassword: String): Observable<UserResponse>

    fun saveUserInfo(user: User)

}