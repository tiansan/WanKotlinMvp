package com.wankotlin.mvp.ui.base.view

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.wankotlin.mvp.util.CommonUtil
import com.wankotlin.mvp.widget.LoadingStateView
import com.yanzhenjie.loading.dialog.LoadingDialog
import dagger.android.support.AndroidSupportInjection


/**
 * Created by jyotidubey on 12/01/18.
 */
abstract class BaseFragment : Fragment(), MVPView {

    private var parentActivity: BaseActivity? = null
    private var progressDialog: LoadingDialog? = null
    protected var mLoadingStateView : LoadingStateView? = null
    /**
     * 当前页面需要加载的layoutId，等价setContentView
     */
    abstract val inflateId: Int

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mLoadingStateView = LoadingStateView(context!!)
        if (context is BaseActivity) {
            val activity = context as BaseActivity?
            this.parentActivity = activity
            activity?.onFragmentAttached()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDependencyInjection()
        setHasOptionsMenu(false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(inflateId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    override fun hideProgress() {
        if (progressDialog != null && progressDialog?.isShowing!!) {
            progressDialog?.cancel()
        }
    }

    override fun showProgress() {
        hideProgress()
        progressDialog = CommonUtil.showLoadingDialog(this.context)
    }

    fun getBaseActivity() = parentActivity

    private fun performDependencyInjection() = AndroidSupportInjection.inject(this)

    interface CallBack {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String)
    }

    abstract fun setUp()

    override fun showMessage(msg: String) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(msgIds: Int) {
        Toast.makeText(activity, msgIds, Toast.LENGTH_SHORT).show()
    }
}