package com.wankotlin.mvp.ui.collect.presenter

import com.wankotlin.mvp.ui.base.presenter.BasePresenter
import com.wankotlin.mvp.ui.collect.interactor.CollectMVPInteractor
import com.wankotlin.mvp.ui.collect.view.CollectMVPView
import com.wankotlin.mvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by jyotidubey on 04/01/18.
 */
class CollectPresenter<V : CollectMVPView, I : CollectMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), CollectMVPPresenter<V, I> {


}