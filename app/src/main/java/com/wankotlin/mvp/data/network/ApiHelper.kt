package com.wankotlin.mvp.data.network

import com.wankotlin.mvp.data.network.model.HomeArticlesResponse
import com.wankotlin.mvp.data.network.model.HomeBannerResponse
import com.wankotlin.mvp.data.network.model.WebResponse
import io.reactivex.Observable

/**
 * Created by jyotidubey on 04/01/18.
 */
interface ApiHelper {

    fun getHomeArticles(page: String): Observable<HomeArticlesResponse>

    fun getHomeBanner(): Observable<HomeBannerResponse>

    fun postWebCollect(id: Int): Observable<WebResponse>

    fun postWebUnCollect(id: Int): Observable<WebResponse>

    fun postWebUnCollectPage(id: Int, originId: Int): Observable<WebResponse>

}