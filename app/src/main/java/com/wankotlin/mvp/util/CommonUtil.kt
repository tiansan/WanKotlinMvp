package com.wankotlin.mvp.util

import android.content.Context
import com.yanzhenjie.loading.dialog.LoadingDialog

/**
 * Created by jyotidubey on 11/01/18.
 */
object CommonUtil {

    fun showLoadingDialog(context: Context?): LoadingDialog {
        val progressDialog = LoadingDialog(context)
        progressDialog.let {
            it.setMessage("")
            it.setCancelable(false)
            it.setCanceledOnTouchOutside(false)
            if (!it.isShowing) {
                it.show()
            }
            return it
        }
    }

}