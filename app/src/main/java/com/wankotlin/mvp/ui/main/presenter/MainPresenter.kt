package com.wankotlin.mvp.ui.main.presenter

import com.wankotlin.mvp.ui.base.presenter.BasePresenter
import com.wankotlin.mvp.ui.main.interactor.MainMVPInteractor
import com.wankotlin.mvp.ui.main.view.MainMVPView
import com.wankotlin.mvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by jyotidubey on 04/01/18.
 */
class MainPresenter<V : MainMVPView, I : MainMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), MainMVPPresenter<V, I> {

}