package com.wankotlin.mvp.data.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.content.edit
import com.wankotlin.mvp.di.PreferenceInfo
import com.wankotlin.mvp.util.AppConstants
import javax.inject.Inject

/**
 * Created by jyotidubey on 04/01/18.
 */
class AppPreferenceHelper @Inject constructor(context: Context,
                                              @PreferenceInfo private val prefFileName: String) : PreferenceHelper {

    companion object {
        private val PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE"
        private val PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID"
        private val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
        private val PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME"
        private val PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL"
        private val PREF_KEY_CURRENT_USER_TYPE = "PREF_KEY_CURRENT_USER_TYPE"
        private val PREF_KEY_CURRENT_USER_PASSWORD = "PREF_KEY_CURRENT_USER_PASSWORD"
        private val PREF_KEY_CURRENT_USER_ICON = "PREF_KEY_CURRENT_USER_ICON"
        private val PREF_KEY_USER_COOKIES = "PREF_KEY_USER_COOKIES"
    }

    private val mPrefs: SharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override fun getCurrentUserLoggedInMode() = mPrefs.getInt(PREF_KEY_USER_LOGGED_IN_MODE, AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type)

    override fun getCurrentUserName(): String = mPrefs.getString(PREF_KEY_CURRENT_USER_NAME, "")
            ?: ""

    override fun setCurrentUserName(userName: String?) = mPrefs.edit { putString(PREF_KEY_CURRENT_USER_NAME, userName) }

    override fun getCurrentUserEmail(): String = mPrefs.getString(PREF_KEY_CURRENT_USER_EMAIL, "")
            ?: ""

    override fun setCurrentUserEmail(email: String?) = mPrefs.edit { putString(PREF_KEY_CURRENT_USER_EMAIL, email) }

    override fun getAccessToken(): String = mPrefs.getString(PREF_KEY_ACCESS_TOKEN, "") ?: ""

    override fun setAccessToken(accessToken: String?) = mPrefs.edit { putString(PREF_KEY_ACCESS_TOKEN, accessToken) }

    override fun getCurrentUserId(): Int {
        val userId = mPrefs.getInt(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX)
        return when (userId) {
            AppConstants.NULL_INDEX -> -1
            else -> userId
        }
    }

    override fun setCurrentUserId(userId: Int?) {
        val id = userId ?: AppConstants.NULL_INDEX
        mPrefs.edit { putInt(PREF_KEY_CURRENT_USER_ID, id) }
    }

    override fun setCurrentUserLoggedInMode(mode: AppConstants.LoggedInMode) {
        mPrefs.edit { putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.type) }
    }

    override fun getCookie(): HashSet<String> =
            mPrefs.getStringSet(PREF_KEY_USER_COOKIES, hashSetOf<String>()) as HashSet<String>

    override fun saveCookie(set: HashSet<String>?) =
            mPrefs.edit { putStringSet(PREF_KEY_USER_COOKIES, set) }

    override fun getCurrentUserIcon(): String = mPrefs.getString(PREF_KEY_CURRENT_USER_ICON, "")
            ?: ""

    override fun setCurrentUserIcon(icon: String?) = mPrefs.edit { putString(PREF_KEY_CURRENT_USER_ICON, icon) }

    override fun getCurrentUserPassword(): String = mPrefs.getString(PREF_KEY_CURRENT_USER_PASSWORD, "")
            ?: ""

    override fun setCurrentUserPassword(password: String?) = mPrefs.edit { putString(PREF_KEY_CURRENT_USER_PASSWORD, password) }

    override fun getCurrentUserType(): Int = mPrefs.getInt(PREF_KEY_CURRENT_USER_TYPE, -1)

    override fun setCurrnetUserType(type: Int) = mPrefs.edit { putInt(PREF_KEY_CURRENT_USER_TYPE, type) }

}