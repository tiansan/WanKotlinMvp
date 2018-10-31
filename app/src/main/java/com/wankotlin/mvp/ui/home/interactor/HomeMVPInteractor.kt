package com.wankotlin.mvp.ui.home.interactor

import com.wankotlin.mvp.data.network.model.HomeArticlesResponse
import com.wankotlin.mvp.data.network.model.HomeBannerResponse
import com.wankotlin.mvp.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface HomeMVPInteractor : MVPInteractor {

    fun getHomeArticles(page: String): Observable<HomeArticlesResponse>

    fun getHomeBanner(): Observable<HomeBannerResponse>
}