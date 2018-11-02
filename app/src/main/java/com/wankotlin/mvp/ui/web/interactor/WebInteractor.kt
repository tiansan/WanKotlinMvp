package com.wankotlin.mvp.ui.web.interactor

import com.wankotlin.mvp.data.network.ApiHelper
import com.wankotlin.mvp.data.network.model.BaseResponse
import com.wankotlin.mvp.data.preferences.PreferenceHelper
import com.wankotlin.mvp.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by jyotidubey on 04/01/18.
 */
class WebInteractor @Inject constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper), WebMVPInteractor {

    override fun postWebCollect(id: Int): Observable<BaseResponse> =
            apiHelper.postWebCollect(id)

    override fun postWebUnCollect(id: Int): Observable<BaseResponse> =
            apiHelper.postWebUnCollect(id)

    override fun postWebUnCollectPage(id: Int, originId: Int): Observable<BaseResponse> =
            apiHelper.postWebUnCollectPage(id, originId)

}