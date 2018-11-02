package com.wankotlin.mvp.ui.my.interactor

import com.wankotlin.mvp.data.network.ApiHelper
import com.wankotlin.mvp.data.network.model.BaseResponse
import com.wankotlin.mvp.data.preferences.PreferenceHelper
import com.wankotlin.mvp.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

class MyInteractor @Inject constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper), MyMVPInteractor {

    override fun doUserLogout(): Observable<BaseResponse> = apiHelper.doUserLogout()
}