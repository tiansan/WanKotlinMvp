package com.wankotlin.mvp.data.network

import com.wankotlin.mvp.data.network.model.HomeArticlesResponse
import com.wankotlin.mvp.data.network.model.HomeBannerResponse
import io.reactivex.Observable

/**
 * Created by jyotidubey on 04/01/18.
 */
interface ApiHelper {

    //    fun performServerLogin(request: LoginRequest.ServerLoginRequest): Observable<LoginResponse>
//
//    fun performFBLogin(request: LoginRequest.FacebookLoginRequest): Observable<LoginResponse>
//
//    fun performGoogleLogin(request: LoginRequest.GoogleLoginRequest): Observable<LoginResponse>
//
//    fun performLogoutApiCall(): Observable<LogoutResponse>
//
    fun getHomeArticles(page: String): Observable<HomeArticlesResponse>

    fun getHomeBanner(): Observable<HomeBannerResponse>

}