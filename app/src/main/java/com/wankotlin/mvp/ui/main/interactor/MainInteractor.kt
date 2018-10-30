package com.wankotlin.mvp.ui.main.interactor

import android.content.Context
import com.wankotlin.mvp.data.network.ApiHelper
import com.wankotlin.mvp.data.preferences.PreferenceHelper
import com.wankotlin.mvp.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class MainInteractor @Inject constructor(private val mContext: Context, preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper), MainMVPInteractor {
}