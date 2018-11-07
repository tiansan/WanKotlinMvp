package com.wankotlin.mvp.ui.collect.interactor

import com.wankotlin.mvp.data.network.ApiHelper
import com.wankotlin.mvp.data.preferences.PreferenceHelper
import com.wankotlin.mvp.ui.base.interactor.BaseInteractor
import javax.inject.Inject

/**
 * Created by jyotidubey on 04/01/18.
 */
class CollectInteractor @Inject constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper), CollectMVPInteractor {

}