package com.wankotlin.mvp.ui.web.interactor

import com.wankotlin.mvp.data.network.model.BaseResponse
import com.wankotlin.mvp.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

/**
 * Created by jyotidubey on 04/01/18.
 */
interface WebMVPInteractor : MVPInteractor {

    fun postWebCollect(id: Int): Observable<BaseResponse>

    fun postWebUnCollect(id: Int): Observable<BaseResponse>

    fun postWebUnCollectPage(id: Int, originId: Int): Observable<BaseResponse>
}