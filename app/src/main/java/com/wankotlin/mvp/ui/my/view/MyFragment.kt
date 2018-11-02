package com.wankotlin.mvp.ui.my.view

import android.os.Bundle
import android.view.View
import com.wankotlin.mvp.R
import com.wankotlin.mvp.data.network.model.User
import com.wankotlin.mvp.ui.base.view.BaseFragment
import com.wankotlin.mvp.ui.my.interactor.MyMVPInteractor
import com.wankotlin.mvp.ui.my.presenter.MyMVPPresenter
import com.wankotlin.mvp.ui.web.view.WebActivity
import kotlinx.android.synthetic.main.fragment_my.*
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

class MyFragment : BaseFragment(), MyMVPView {


    @Inject
    internal lateinit var presenter: MyMVPPresenter<MyMVPView, MyMVPInteractor>


    override val inflateId: Int
        get() = R.layout.fragment_my

    companion object {
        fun newInstance(): MyFragment = MyFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }


    override fun setUp() {
        btnLogin.setOnClickListener {
            //            LoginActivity.active(act)
        }
        btnLogout.setOnClickListener {
            showProgress()
            presenter.doLogout()
        }
        btnCollectList.setOnClickListener {
            if (presenter.isUserLoggedIn()) {
//                CollectListActivity.active(activity!!)
            } else {
//                LoginActivity.active(act)
            }
        }
        btnAbout.setOnClickListener {
            val link = "file:///android_asset/web/about.html"
            activity?.let { it1 -> WebActivity.active(it1, link, -1, "wanAndroid", "", false) }
        }
        btnTodo.setOnClickListener {
            toast("待完成...")
        }
        btnKnowSystem.setOnClickListener {
            toast("待完成...")
        }
        btnUpdate.setOnClickListener {
            //            Beta.checkUpgrade()
        }
    }

    override fun onLogoutSuccess() {
        hideProgress()
        setViewLogout()
    }


    override fun setViewLogout() {
        nameImgTv.text = ""
        nameTv.text = ""
        btnLogin.visibility = View.VISIBLE
        nameTv.visibility = View.GONE
        btnLogout.visibility = View.GONE
        logoutLine.visibility = View.GONE
    }

    override fun setViewLogin(user: User?) {
        user?.let {
            nameImgTv.text = it.username.substring(0, 1)
            nameTv.text = it.username
        }
        btnLogin.visibility = View.GONE
        nameTv.visibility = View.VISIBLE
        btnLogout.visibility = View.VISIBLE
        logoutLine.visibility = View.VISIBLE
    }

    private fun openLoginActivity() {

    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

}