package com.wankotlin.mvp.data.preferences

import com.wankotlin.mvp.util.AppConstants

/**
 * Created by jyotidubey on 04/01/18.
 */
interface PreferenceHelper {

    fun getCurrentUserLoggedInMode(): Int

    fun setCurrentUserLoggedInMode(mode: AppConstants.LoggedInMode)

    fun getCurrentUserId(): Int

    fun setCurrentUserId(userId: Int?)

    fun getCurrentUserName(): String

    fun setCurrentUserName(userName: String?)

    fun getCurrentUserEmail(): String

    fun setCurrentUserEmail(email: String?)

    fun getCurrentUserIcon(): String

    fun setCurrentUserIcon(icon: String?)

    fun getCurrentUserPassword(): String

    fun setCurrentUserPassword(password: String?)

    fun getCurrentUserType(): Int

    fun setCurrnetUserType(type: Int)

    fun getAccessToken(): String

    fun setAccessToken(accessToken: String?)

    fun getCookie(): HashSet<String>

    fun saveCookie(set: HashSet<String>?)

}