package com.wankotlin.mvp.ui.my.interactor

import com.wankotlin.mvp.data.network.model.BaseResponse
import com.wankotlin.mvp.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface MyMVPInteractor : MVPInteractor {

    fun doUserLogout(): Observable<BaseResponse>
}