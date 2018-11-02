package com.wankotlin.mvp.ui.my.presenter

import com.wankotlin.mvp.ui.base.presenter.BasePresenter
import com.wankotlin.mvp.ui.my.interactor.MyMVPInteractor
import com.wankotlin.mvp.ui.my.view.MyMVPView
import com.wankotlin.mvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by jyotidubey on 04/01/18.
 */
class MyPresenter<V : MyMVPView, I : MyMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), MyMVPPresenter<V, I> {

    override fun onAttach(view: V?) {
        super.onAttach(view)

        if (isUserLoggedIn()){
            getView()?.setViewLogin(interactor?.getUserInfo())
        }else{
            getView()?.setViewLogout()
        }
    }

    override fun doLogout() {
        interactor?.let {
            compositeDisposable.add(it.doUserLogout()
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe { baseResponse ->
                        if (baseResponse.isSuccess){
                            getView()?.onLogoutSuccess()
                            it.performUserLogout()
                        }else{

                        }
                    })
        }
    }

}