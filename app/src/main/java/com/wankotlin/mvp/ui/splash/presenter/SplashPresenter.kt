package com.wankotlin.mvp.ui.splash.presenter

import com.wankotlin.mvp.ui.base.presenter.BasePresenter
import com.wankotlin.mvp.ui.splash.interactor.SplashMVPInteractor
import com.wankotlin.mvp.ui.splash.view.SplashMVPView
import com.wankotlin.mvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by jyotidubey on 04/01/18.
 */
class SplashPresenter<V : SplashMVPView, I : SplashMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), SplashMVPPresenter<V, I> {

}