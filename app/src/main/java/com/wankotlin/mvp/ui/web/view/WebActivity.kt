package com.wankotlin.mvp.ui.web.view

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.http.SslError
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import android.widget.LinearLayout
import com.wankotlin.mvp.R
import com.wankotlin.mvp.ui.base.view.BaseActivity
import com.wankotlin.mvp.ui.web.interactor.WebMVPInteractor
import com.wankotlin.mvp.ui.web.presenter.WebMVPPresenter
import com.wankotlin.mvp.widget.*
import kotlinx.android.synthetic.main.activity_web.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.share
import org.jetbrains.anko.toast
import javax.inject.Inject

class WebActivity : BaseActivity(), WebMVPView {

    @Inject
    lateinit var presenter: WebMVPPresenter<WebMVPView, WebMVPInteractor>

    companion object {
        fun active(act: Activity, link: String, id: Int, author: String, title: String, collect: Boolean, originId: Int = 0) {
            var intent = Intent(act, WebActivity::class.java)
            intent.putExtra("link", link)
            intent.putExtra("id", id)
            intent.putExtra("author", author)
            intent.putExtra("title", title)
            intent.putExtra("originId", originId)
            intent.putExtra("collect", collect)
            act.startActivity(intent)
        }
    }

    private val webView: WebView by lazy { WebView(this) }
    private var url: String = ""
    private var id: Int = -1
    private var author: String = ""
    private var title: String = ""
    private var collect: Boolean = false
    private var originId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        presenter.onAttach(this)

        initIntent()
        initView()

    }

    private fun initView() {
        btnBack.setOnClickListener { onBackPressed() }
        btnClose.setOnClickListener { finish() }
        btnOther.visibility = if (id == -1) View.GONE else View.VISIBLE
        btnOther.setOnClickListener { showOtherDialog() }
        webView.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        webLayout.addView(webView)

        webView.settings.apply {
            allowFileAccess = false
            javaScriptEnabled = false
            loadWithOverviewMode = true
            useWideViewPort = true
            defaultTextEncodingName = "gb2312"
            setAppCacheEnabled(true)
            mediaPlaybackRequiresUserGesture = false
            cacheMode = WebSettings.LOAD_DEFAULT
            databaseEnabled = true
//            setRenderPriority(WebSettings.RenderPriority.HIGH)
            blockNetworkImage = false
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            }
        }
        webView.webViewClient = object : WebViewClient() {
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                view?.loadUrl(request?.url.toString())
                return super.shouldOverrideUrlLoading(view, request)
            }

            // 即使加载失败后，webview执行完onReceivedError()方法也会执行这个方法
            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                webView.settings.blockNetworkImage = false
                if (!TextUtils.isEmpty(view.title)) {
                    titleTv.text = view.title//webView获取到网页title
                }
            }

            override fun onReceivedSslError(view: WebView, handler: SslErrorHandler, error: SslError) {
                handler.proceed()
            }
        }
        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                progressbar.progress = newProgress
                if (newProgress >= 100) {
                    view?.post {
                        progressbar.visibility = View.GONE
                        if (view.canGoBack()) {
                            btnClose.visibility = View.VISIBLE
                        } else {
                            btnClose.visibility = View.GONE
                        }
                    }
                } else {
                    if (progressbar.visibility == View.GONE) {
                        view?.post { progressbar.visibility = View.VISIBLE }
                    }
                }
            }
        }
        WebView.setWebContentsDebuggingEnabled(true)        //将 WebViews 配置为可调试状态
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        webView.loadUrl(url)
    }

    private fun initIntent() {
        url = intent?.getStringExtra("link") ?: "http://www.wanandroid.com/"
        author = intent?.getStringExtra("author") ?: "wanAndroid"
        title = intent?.getStringExtra("title") ?: "wanAndroid"
        id = intent?.getIntExtra("id", -1) ?: -1
        originId = intent?.getIntExtra("originId", 0) ?: 0
        collect = intent?.getBooleanExtra("collect", false) ?: false
    }

    private fun showOtherDialog() {
        val dialog = OtherBottomDialog.getDialog(collect)
        dialog.show(supportFragmentManager, "otherDialog")
        dialog.onItemClick = {
            when (it) {
                TYPE_SHARE -> {
                    share(url, title)
                }
                TYPE_COLLECT -> {
                    presenter.decideActivityToOpen(collect, originId, id)
                }
                TYPE_COPY -> {
                    copyUrl()
                }
                TYPE_BROWSER -> {
                    browse(url)
                }
            }
            dialog.dismiss()
        }
    }

    /**
     * 复制链接
     */
    private fun copyUrl() {
        val cm = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        cm.primaryClip = ClipData.newPlainText(null, url)
        showMessage("已成功复制!")
    }

    override fun onCollectSuccess() {
        collect = true
        toast("收藏成功")
    }

    override fun onUnCollectSuccess() {
        collect = false
        toast("取消收藏成功")
    }

    override fun onUnCollectPageSuccess() {
        collect = false
        btnOther.visibility = View.GONE
        toast("取消收藏成功")
    }

    override fun openLoginActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentAttached() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentDetached(tag: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResume() {
        super.onResume()
        webView.onResume()
    }

    override fun onPause() {
        super.onPause()
        webView.onPause()
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
        webView.apply {
            webViewClient = null
            webChromeClient = null
            (parent as ViewGroup).removeView(webView)
            removeAllViews()
            destroy()
        }
    }
}
