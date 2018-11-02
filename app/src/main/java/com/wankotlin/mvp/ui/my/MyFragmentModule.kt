package com.wankotlin.mvp.ui.my

import com.wankotlin.mvp.ui.my.interactor.MyInteractor
import com.wankotlin.mvp.ui.my.interactor.MyMVPInteractor
import com.wankotlin.mvp.ui.my.presenter.MyMVPPresenter
import com.wankotlin.mvp.ui.my.presenter.MyPresenter
import com.wankotlin.mvp.ui.my.view.MyMVPView
import dagger.Module
import dagger.Provides


@Module
class MyFragmentModule {

    @Provides
    internal fun providerMyInteractor(interactor: MyInteractor): MyMVPInteractor = interactor

    @Provides
    internal fun providerMyPresenter(presenter: MyPresenter<MyMVPView, MyMVPInteractor>): MyMVPPresenter<MyMVPView, MyMVPInteractor> = presenter

}