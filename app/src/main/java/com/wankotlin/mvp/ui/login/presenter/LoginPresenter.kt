package com.wankotlin.mvp.ui.login.presenter

import com.wankotlin.mvp.ui.base.presenter.BasePresenter
import com.wankotlin.mvp.ui.login.interactor.LoginMVPInteractor
import com.wankotlin.mvp.ui.login.view.LoginMVPView
import com.wankotlin.mvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by jyotidubey on 04/01/18.
 */
class LoginPresenter<V : LoginMVPView, I : LoginMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), LoginMVPPresenter<V, I> {

    override fun login(userName: String, password: String) {
        interactor?.let {
            compositeDisposable.add(it.doUserLogin(userName, password)
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe { userRespojse ->
                        getView()?.onLoginSuccess(userRespojse.data)
                    })
        }
    }

    override fun register(userName: String, password: String, rePassword: String) {
        interactor?.let {
            compositeDisposable.add(it.doUserRegister(userName, password, rePassword)
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe { userResponse ->
                        getView()?.onRegisterSuccess(userResponse.data)
                    })
        }
    }

}