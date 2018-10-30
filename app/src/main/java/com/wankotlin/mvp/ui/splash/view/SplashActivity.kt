package com.wankotlin.mvp.ui.splash.view

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.wankotlin.mvp.R
import com.wankotlin.mvp.ui.base.view.BaseActivity
import com.wankotlin.mvp.ui.main.view.MainActivity
import com.wankotlin.mvp.ui.splash.interactor.SplashMVPInteractor
import com.wankotlin.mvp.ui.splash.presenter.SplashMVPPresenter
import com.wankotlin.mvp.util.AppUtils
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashMVPView {

    @Inject
    lateinit var presenter: SplashMVPPresenter<SplashMVPView, SplashMVPInteractor>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        presenter.onAttach(this)
        setVersion()
        requestEachPermissions(Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }

    private fun setVersion() {
        versionTv.text = "v${AppUtils.getVersionName(this)}"
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun onFragmentAttached() {
    }


    override fun acceptPermission(isGranted: Boolean) {
        if (isGranted) {
            versionTv.postDelayed({ openMainActivity() }, 2000)
        } else {
            showPermissionDeniedDialog()
        }
    }

    private fun showPermissionDeniedDialog() {
        AlertDialog.Builder(this).apply {
            setTitle("温馨提示")
            setMessage("你拒绝了权限请求，会影响应用更新等功能的正常使用！")
            setPositiveButton("去设置") { _, _ ->
                requestEachPermissions(Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }
            setNegativeButton("取消") { _, _ ->
                versionTv.postDelayed({ openMainActivity() }, 2000)
            }
            setCancelable(false)
            setFinishOnTouchOutside(false)
        }.create().show()
    }

    override fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}
