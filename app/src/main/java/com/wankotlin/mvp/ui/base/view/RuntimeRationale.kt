package com.wankotlin.mvp.ui.base.view

import android.content.Context
import com.yanzhenjie.permission.Rationale
import com.yanzhenjie.permission.RequestExecutor

class RuntimeRationale() : Rationale {
    override fun showRationale(context: Context?, permissions: MutableList<String>?, executor: RequestExecutor?) {
        executor?.execute()
    }
}