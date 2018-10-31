package com.wankotlin.mvp.ui.home.view

import com.wankotlin.mvp.data.network.model.HomeArticles
import com.wankotlin.mvp.ui.base.view.MVPView

interface HomeMVPView : MVPView {

    fun updateHomeArticles(data: HomeArticles)
}