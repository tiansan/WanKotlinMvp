package com.wankotlin.mvp.ui.login.view

import android.os.Bundle
import android.view.View
import com.wankotlin.mvp.R
import com.wankotlin.mvp.data.network.model.User
import com.wankotlin.mvp.ui.base.view.BaseActivity
import com.wankotlin.mvp.ui.login.interactor.LoginMVPInteractor
import com.wankotlin.mvp.ui.login.presenter.LoginPresenter
import com.wankotlin.mvp.util.hideSoftInput
import kotlinx.android.synthetic.main.activity_loglin.*
import kotlinx.android.synthetic.main.layout_login.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginMVPView {

    @Inject
    lateinit var presenter: LoginPresenter<LoginMVPView, LoginMVPInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loglin)

        setUp()
    }

    private fun setUp() {
        btnBack.setOnClickListener {
            onBackPressed()
        }
        loginTag.setColorFilter(resources.getColor(R.color.black_1, null))
        registerTag.setColorFilter(resources.getColor(R.color.black_1, null))
        loginBtn.setOnClickListener {
            showLoginOrRegister(true)
        }
        registerBtn.setOnClickListener {
            showLoginOrRegister(false)
        }
        btnGoLogin.setOnClickListener {
            login()
        }
        btnGoRegister.setOnClickListener {
            register()
        }
    }

    private fun login() {
        val userName = loginNameTV.text.toString()
        val password = loginPasswordTv.text.toString()
        if (userName.isBlank()) {
            toast("请输入用户名")
            return
        }
        if (password.isBlank()) {
            toast("请输入密码")
            return
        }
        hideSoftInput()
        showProgress()
        presenter.login(userName, password)
    }

    private fun register() {
        val userName = registerNameTv.text.toString()
        val password = registerPwdTv.text.toString()
        val rePassword = registerRePwdTv.text.toString()
        if (userName.isBlank()) {
            toast("请输入用户名")
            return
        }
        if (password.isBlank()) {
            toast("请输入密码")
            return
        }
        if (rePassword.isBlank()) {
            toast("请输入密码")
            return
        }
        if (password != rePassword) {
            toast("密码不一致，请确认")
            return
        }
        hideSoftInput()
        showProgress()
        presenter.register(userName, password, rePassword)
    }

    private var isSelectLogin = true

    private fun showLoginOrRegister(isLogin: Boolean) {
        isSelectLogin = isLogin
        loginTag.visibility = if (isLogin) View.VISIBLE else View.INVISIBLE
        registerTag.visibility = if (!isLogin) View.VISIBLE else View.INVISIBLE
        loginLayout.visibility = if (isLogin) View.VISIBLE else View.INVISIBLE
        registerLayout.visibility = if (!isLogin) View.VISIBLE else View.INVISIBLE
    }

    override fun onLoginSuccess(user: User) {
        hideProgress()
//        EventBus.getDefault().post(user)
        finish()
    }

    override fun onLoginFailed(msg: String) {
        hideProgress()
        toast(msg)
    }

    override fun onRegisterSuccess(user: User) {
        hideProgress()
        toast("注册并成功登录")
//        App.instance.user = user
//        EventBus.getDefault().post(user)
        finish()
    }

    override fun onRegisterFailed(msg: String) {
        hideProgress()
        toast(msg)
    }

    override fun onFragmentAttached() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentDetached(tag: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
