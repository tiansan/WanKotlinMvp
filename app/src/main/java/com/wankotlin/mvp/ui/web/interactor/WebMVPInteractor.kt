package com.wankotlin.mvp.ui.web.interactor

import com.wankotlin.mvp.data.network.model.WebResponse
import com.wankotlin.mvp.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

/**
 * Created by jyotidubey on 04/01/18.
 */
interface WebMVPInteractor : MVPInteractor {

    fun postWebCollect(id: Int): Observable<WebResponse>

    fun postWebUnCollect(id: Int): Observable<WebResponse>

    fun postWebUnCollectPage(id: Int, originId: Int): Observable<WebResponse>
}