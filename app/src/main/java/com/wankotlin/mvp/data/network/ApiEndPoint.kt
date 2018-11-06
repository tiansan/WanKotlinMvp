package com.wankotlin.mvp.data.network

import com.wankotlin.mvp.BuildConfig

/**
 * Created by jyotidubey on 11/01/18.
 */
object ApiEndPoint {

    val HOME_ARTICLES = BuildConfig.BASE_URL + "/article/list/{page}/json"
    val HOME_BANNER = BuildConfig.BASE_URL + "/banner/json"
    val WEB_COLLECT = BuildConfig.BASE_URL + "/lg/collect/{id}/json"
    val WEB_UNCOLLECT = BuildConfig.BASE_URL + "/lg/uncollect_originId/{id}/json"
    val WEB_UNCOLLECT_PAGE = BuildConfig.BASE_URL + "/lg/uncollect/{id}/json"
    val USER_LOGOUT = BuildConfig.BASE_URL + "/user/logout/json"
    val USER_LOGIN = BuildConfig.BASE_URL + "/user/login"
    val USER_REGISTER = BuildConfig.BASE_URL + "/user/register"

}