package com.wankotlin.mvp.ui.web.presenter

import com.wankotlin.mvp.ui.base.presenter.BasePresenter
import com.wankotlin.mvp.ui.web.interactor.WebMVPInteractor
import com.wankotlin.mvp.ui.web.view.WebMVPView
import com.wankotlin.mvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by jyotidubey on 04/01/18.
 */
class WebPresenter<V : WebMVPView, I : WebMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), WebMVPPresenter<V, I> {

    override fun decideActivityToOpen(collect: Boolean, originId: Int, id: Int) {
        if (isUserLoggedIn()) {
            if (!collect) {
                articleCollect(id)
            } else {
                if (originId == 0) {
                    articleUncollect(id)
                } else {
                    articleUncollectPage(id, originId)
                }
            }
        } else {
            getView()?.openLoginActivity()
        }
    }

    private fun articleUncollectPage(id: Int, originId: Int) {
        interactor?.let {
            compositeDisposable.add(it.postWebUnCollectPage(id, originId)
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe { webResponse ->
                        if (webResponse.isSuccess) {
                            getView()?.onUnCollectPageSuccess()
                        } else {
                            getView()?.showMessage(webResponse.errorMsg)
                        }
                    })
        }
    }

    private fun articleUncollect(id: Int) {
        interactor?.let {
            compositeDisposable.add(it.postWebUnCollect(id)
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe { webResponse ->
                        if (webResponse.isSuccess) {
                            getView()?.onUnCollectSuccess()
                        } else {
                            getView()?.showMessage(webResponse.errorMsg)
                        }
                    })
        }
    }

    private fun articleCollect(id: Int) {
        interactor?.let {
            compositeDisposable.add(it.postWebCollect(id)
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe { webResponse ->
                        if (webResponse.isSuccess) {
                            getView()?.onCollectSuccess()
                        } else {
                            getView()?.showMessage(webResponse.errorMsg)
                        }
                    })
        }

    }

}