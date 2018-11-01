package com.wankotlin.mvp.ui.base.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.wankotlin.mvp.util.CommonUtil
import com.yanzhenjie.loading.dialog.LoadingDialog
import com.yanzhenjie.permission.AndPermission
import dagger.android.AndroidInjection

/**
 * Created by jyotidubey on 04/01/18.
 */
abstract class BaseActivity : AppCompatActivity(), MVPView, BaseFragment.CallBack {

    private var progressDialog: LoadingDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDI()
    }

    override fun hideProgress() {
        progressDialog?.let { if (it.isShowing) it.cancel() }
    }

    override fun showProgress() {
        hideProgress()
        progressDialog = CommonUtil.showLoadingDialog(this)
    }

    private fun performDI() = AndroidInjection.inject(this)

    fun requestEachPermissions(vararg permissions: String) {
        AndPermission.with(this)
                .permission(*permissions)
                .rationale(RuntimeRationale())
                .onGranted { acceptPermission(true) }
                .onDenied { permissions ->
                    acceptPermission(false)
                    if (AndPermission.hasAlwaysDeniedPermission(this@BaseActivity, permissions)) {
                        AndPermission.permissionSetting(this@BaseActivity)
                                .execute()
                    }
                }
                .start()
    }

    open fun acceptPermission(isGranted: Boolean) {

    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(msgIds: Int) {
        Toast.makeText(this, msgIds, Toast.LENGTH_SHORT).show()
    }

}