package com.wankotlin.mvp.data.network

import com.wankotlin.mvp.data.network.model.BaseResponse
import com.wankotlin.mvp.data.network.model.HomeArticlesResponse
import com.wankotlin.mvp.data.network.model.HomeBannerResponse
import com.wankotlin.mvp.data.network.model.UserResponse
import io.reactivex.Observable

/**
 * Created by jyotidubey on 04/01/18.
 */
interface ApiHelper {

    fun getHomeArticles(page: String): Observable<HomeArticlesResponse>

    fun getHomeBanner(): Observable<HomeBannerResponse>

    fun postWebCollect(id: Int): Observable<BaseResponse>

    fun postWebUnCollect(id: Int): Observable<BaseResponse>

    fun postWebUnCollectPage(id: Int, originId: Int): Observable<BaseResponse>

    fun doUserLogout(): Observable<BaseResponse>

    fun doUserLogin(userName: String, password: String): Observable<UserResponse>

    fun doUserRegister(userName: String, password: String, repassword: String): Observable<UserResponse>
}