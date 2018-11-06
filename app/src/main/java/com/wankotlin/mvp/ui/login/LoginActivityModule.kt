package com.wankotlin.mvp.ui.login

import com.wankotlin.mvp.ui.login.interactor.LoginInteractor
import com.wankotlin.mvp.ui.login.interactor.LoginMVPInteractor
import com.wankotlin.mvp.ui.login.presenter.LoginMVPPresenter
import com.wankotlin.mvp.ui.login.presenter.LoginPresenter
import com.wankotlin.mvp.ui.login.view.LoginMVPView
import dagger.Module
import dagger.Provides

/**
 * Created by jyotidubey on 06/01/18.
 */
@Module
class LoginActivityModule {

    @Provides
    internal fun provideLoginInteractor(loginInteractor: LoginInteractor): LoginMVPInteractor = loginInteractor

    @Provides
    internal fun provideLoginPresenter(loginPresenter: LoginPresenter<LoginMVPView, LoginMVPInteractor>)
            : LoginMVPPresenter<LoginMVPView, LoginMVPInteractor> = loginPresenter
}