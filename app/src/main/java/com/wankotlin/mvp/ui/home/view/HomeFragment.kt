package com.wankotlin.mvp.ui.home.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.ImageView
import cn.bingoogolapple.bgabanner.BGABanner
import com.wankotlin.mvp.R
import com.wankotlin.mvp.adapter.HomeAdapter
import com.wankotlin.mvp.data.network.model.Banner
import com.wankotlin.mvp.data.network.model.HomeArticles
import com.wankotlin.mvp.ui.base.view.BaseFragment
import com.wankotlin.mvp.ui.home.interactor.HomeMVPInteractor
import com.wankotlin.mvp.ui.home.presenter.HomeMVPPresenter
import com.wankotlin.mvp.util.extension.loadImage
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.layout_home_banner.view.*
import javax.inject.Inject

class HomeFragment : BaseFragment(), HomeMVPView {

    @Inject
    internal lateinit var presenter: HomeMVPPresenter<HomeMVPView, HomeMVPInteractor>
    private val mAdapter by lazy { HomeAdapter() }
    private lateinit var mBannerView: BGABanner
    private var page: Int = 0


    override val inflateId: Int
        get() = R.layout.fragment_home

    companion object {
        fun newInstance(): HomeFragment = HomeFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        presenter.getHomeArticles("0")
        super.onViewCreated(view, savedInstanceState)
    }


    override fun setUp() {
        val bannerView = View.inflate(context, R.layout.layout_home_banner, null)
        mBannerView = bannerView.bannerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = mAdapter
        recyclerView.addItemDecoration(
                HorizontalDividerItemDecoration.Builder(activity)
                        .colorResId(R.color.backgroundColor)
                        .sizeResId(R.dimen.d_8)
                        .visibilityProvider { position, _ ->
                    position == 0
                }.build()
        )
        mAdapter.addHeaderView(bannerView)
        mBannerView.setAdapter { banner, itemView, model, position ->
            val imageView: ImageView = itemView as ImageView
            val bannerItem = model as Banner
            imageView.loadImage(bannerItem.imagePath)
        }
        mAdapter.setOnLoadMoreListener({
            page++
            presenter.getHomeArticles(page.toString())
        }, recyclerView)
        mAdapter.setPreLoadNumber(2)
        refreshLayout.setOnRefreshListener {
            initData()
        }
        mAdapter.setOnItemClickListener { adapter, view, position ->
//            mAdapter.data[position]?.apply {
//                WebActivity.active(act, link, id, author, title, collect)
//            }
        }
        mAdapter.emptyView = mLoadingStateView
        mLoadingStateView?.setOnReloadClickListener {
            initData()
        }
        mBannerView.setDelegate { _, _, model, _ ->
            val bannerItem = model as Banner
            bannerItem.apply {
//                WebActivity.active(act, url, -1, "wanAndroid", title, collect = false)
            }
        }
    }

    private fun initData() {
        mLoadingStateView?.loading()
        page = 0
        presenter.getHomeArticles(page.toString())
    }

    override fun updateHomeArticles(data: HomeArticles) {
        if (data.curPage == 1) {
            mAdapter.setNewData(data.datas)
            refreshLayout.isRefreshing = false
        } else {
            mAdapter.addData(data.datas)
            mAdapter.loadMoreComplete()
        }
        page = data.curPage
        if (data.over) {
            mAdapter.loadMoreEnd()
        }
        mAdapter.setEnableLoadMore(!data.over)
        mLoadingStateView?.success()
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}