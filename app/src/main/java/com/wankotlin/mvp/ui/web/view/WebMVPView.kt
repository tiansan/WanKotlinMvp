package com.wankotlin.mvp.ui.web.view

import com.wankotlin.mvp.ui.base.view.MVPView


/**
 * Created by jyotidubey on 04/01/18.
 */
interface WebMVPView : MVPView {

    fun openLoginActivity()
    fun onCollectSuccess()
    fun onUnCollectSuccess()
    fun onUnCollectPageSuccess()

}