package com.wankotlin.mvp.ui.collect.view

import android.os.Bundle
import com.wankotlin.mvp.R
import com.wankotlin.mvp.ui.base.view.BaseActivity

class CollectActivity : BaseActivity(), CollectMVPView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collect)

    }

    override fun onFragmentAttached() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentDetached(tag: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
