package com.wankotlin.mvp.data.network

import com.rx2androidnetworking.Rx2AndroidNetworking
import com.wankotlin.mvp.data.network.model.HomeArticlesResponse
import com.wankotlin.mvp.data.network.model.HomeBannerResponse
import com.wankotlin.mvp.data.network.model.WebResponse
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by jyotidubey on 04/01/18.
 */
class AppApiHelper @Inject constructor(private val apiHeader: ApiHeader) : ApiHelper {

    override fun getHomeBanner(): Observable<HomeBannerResponse> =
            Rx2AndroidNetworking.get(ApiEndPoint.HOME_BANNER)
                    .build()
                    .getObjectObservable(HomeBannerResponse::class.java)

    override fun getHomeArticles(page: String): Observable<HomeArticlesResponse> =
            Rx2AndroidNetworking.get(ApiEndPoint.HOME_ARTICLES)
                    .addPathParameter("page", page)
                    .build()
                    .getObjectObservable(HomeArticlesResponse::class.java)

    override fun postWebCollect(id: Int): Observable<WebResponse> =
            Rx2AndroidNetworking.post(ApiEndPoint.WEB_COLLECT)
                    .addPathParameter("id", id.toString())
                    .build()
                    .getObjectObservable(WebResponse::class.java)

    override fun postWebUnCollect(id: Int): Observable<WebResponse> =
            Rx2AndroidNetworking.post(ApiEndPoint.WEB_UNCOLLECT)
                    .addPathParameter("id", id.toString())
                    .build()
                    .getObjectObservable(WebResponse::class.java)

    override fun postWebUnCollectPage(id: Int, originId: Int): Observable<WebResponse> =
            Rx2AndroidNetworking.post(ApiEndPoint.WEB_UNCOLLECT_PAGE)
                    .addPathParameter("id", id.toString())
                    .addQueryParameter("originId", originId.toString())
                    .build()
                    .getObjectObservable(WebResponse::class.java)
}