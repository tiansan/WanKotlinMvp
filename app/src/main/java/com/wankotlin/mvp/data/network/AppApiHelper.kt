package com.wankotlin.mvp.data.network

import com.rx2androidnetworking.Rx2AndroidNetworking
import com.wankotlin.mvp.data.network.model.BaseResponse
import com.wankotlin.mvp.data.network.model.HomeArticlesResponse
import com.wankotlin.mvp.data.network.model.HomeBannerResponse
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

    override fun postWebCollect(id: Int): Observable<BaseResponse> =
            Rx2AndroidNetworking.post(ApiEndPoint.WEB_COLLECT)
                    .addPathParameter("id", id.toString())
                    .build()
                    .getObjectObservable(BaseResponse::class.java)

    override fun postWebUnCollect(id: Int): Observable<BaseResponse> =
            Rx2AndroidNetworking.post(ApiEndPoint.WEB_UNCOLLECT)
                    .addPathParameter("id", id.toString())
                    .build()
                    .getObjectObservable(BaseResponse::class.java)

    override fun postWebUnCollectPage(id: Int, originId: Int): Observable<BaseResponse> =
            Rx2AndroidNetworking.post(ApiEndPoint.WEB_UNCOLLECT_PAGE)
                    .addPathParameter("id", id.toString())
                    .addUrlEncodeFormBodyParameter("originId", originId.toString())
                    .build()
                    .getObjectObservable(BaseResponse::class.java)

    override fun doUserLogout(): Observable<BaseResponse> =
            Rx2AndroidNetworking.get(ApiEndPoint.USER_LOGOUT)
                    .build()
                    .getObjectObservable(BaseResponse::class.java)
}