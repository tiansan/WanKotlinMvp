package com.wankotlin.mvp.ui.main

import com.wankotlin.mvp.ui.main.interactor.MainInteractor
import com.wankotlin.mvp.ui.main.interactor.MainMVPInteractor
import com.wankotlin.mvp.ui.main.presenter.MainMVPPresenter
import com.wankotlin.mvp.ui.main.presenter.MainPresenter
import com.wankotlin.mvp.ui.main.view.MainMVPView
import dagger.Module
import dagger.Provides


@Module
class MainActivityModule {

    @Provides
    internal fun provideMainInteractor(mainInteractor: MainInteractor)
            : MainMVPInteractor = mainInteractor

    @Provides
    internal fun provideMainPreserter(mainPresenter: MainPresenter<MainMVPView, MainMVPInteractor>)
            : MainMVPPresenter<MainMVPView, MainMVPInteractor> = mainPresenter
}