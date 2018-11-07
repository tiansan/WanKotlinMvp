package com.wankotlin.mvp.ui.collect

import com.wankotlin.mvp.ui.collect.interactor.CollectInteractor
import com.wankotlin.mvp.ui.collect.interactor.CollectMVPInteractor
import com.wankotlin.mvp.ui.collect.presenter.CollectMVPPresenter
import com.wankotlin.mvp.ui.collect.presenter.CollectPresenter
import com.wankotlin.mvp.ui.collect.view.CollectMVPView
import dagger.Module
import dagger.Provides

/**
 * Created by jyotidubey on 06/01/18.
 */
@Module
class CollectActivityModule {

    @Provides
    internal fun provideCollectInteractor(collectInteractor: CollectInteractor): CollectMVPInteractor = collectInteractor

    @Provides
    internal fun provideCollectPresenter(collectPresenter: CollectPresenter<CollectMVPView, CollectMVPInteractor>)
            : CollectMVPPresenter<CollectMVPView, CollectMVPInteractor> = collectPresenter
}