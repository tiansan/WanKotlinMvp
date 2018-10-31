package com.wankotlin.mvp.ui.home

import com.wankotlin.mvp.ui.home.interactor.HomeInteractor
import com.wankotlin.mvp.ui.home.interactor.HomeMVPInteractor
import com.wankotlin.mvp.ui.home.presenter.HomeMVPPresenter
import com.wankotlin.mvp.ui.home.presenter.HomePresenter
import com.wankotlin.mvp.ui.home.view.HomeMVPView
import dagger.Module
import dagger.Provides


@Module
class HomeFragmentModule {

    @Provides
    internal fun providerHomeInteractor(interactor: HomeInteractor): HomeMVPInteractor = interactor

    @Provides
    internal fun providerHomePresenter(presenter: HomePresenter<HomeMVPView, HomeMVPInteractor>): HomeMVPPresenter<HomeMVPView, HomeMVPInteractor> = presenter

}