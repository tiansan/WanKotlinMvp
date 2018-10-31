package com.wankotlin.mvp.ui.home.presenter

import com.wankotlin.mvp.ui.base.presenter.BasePresenter
import com.wankotlin.mvp.ui.home.interactor.HomeMVPInteractor
import com.wankotlin.mvp.ui.home.view.HomeMVPView
import com.wankotlin.mvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by jyotidubey on 04/01/18.
 */
class HomePresenter<V : HomeMVPView, I : HomeMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), HomeMVPPresenter<V, I> {

    override fun getHomeBanner() {
        interactor?.let {
            compositeDisposable.add(it.getHomeBanner()
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe({ homeBannerResponse ->
                        getView()?.let {
                            it.updateHomeBanner(homeBannerResponse.data)
                        }
                    }, {
                        getView()?.let { it.updateFailed() }
                    }))
        }
    }

    override fun getHomeArticles(page: String) {
        interactor?.let {
            compositeDisposable.add(it.getHomeArticles(page)
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe({ homeArticlesResponse ->
                        getView()?.let {
                            it.updateHomeArticles(homeArticlesResponse.data)
                        }
                    }, {
                        getView()?.let { it.updateFailed() }
                    }))
        }
    }

}