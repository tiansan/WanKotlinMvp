package com.wankotlin.mvp.ui.main.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.View
import com.wankotlin.mvp.R
import com.wankotlin.mvp.adapter.HomeViewPagerAdapter
import com.wankotlin.mvp.ui.base.view.BaseActivity
import com.wankotlin.mvp.ui.home.view.HomeFragment
import com.wankotlin.mvp.ui.main.interactor.MainMVPInteractor
import com.wankotlin.mvp.ui.main.presenter.MainMVPPresenter
import com.wankotlin.mvp.ui.my.view.MyFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainMVPView, View.OnClickListener, ViewPager.OnPageChangeListener, HasSupportFragmentInjector {

    @Inject
    lateinit var presenter: MainMVPPresenter<MainMVPView, MainMVPInteractor>
    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    private var fragments = mutableListOf<Fragment>()
    private var bottomViews = mutableListOf<View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onAttach(this)
        setUp()
    }

    fun setUp() {
        fragments.add(HomeFragment.newInstance())
        fragments.add(HomeFragment.newInstance())
        fragments.add(HomeFragment.newInstance())
        fragments.add(MyFragment.newInstance())

        homeViewPager.adapter = HomeViewPagerAdapter(fragments, supportFragmentManager)
        homeViewPager.offscreenPageLimit = 4
        homeViewPager.addOnPageChangeListener(this)

        bottomViews.add(rl_home)
        bottomViews.add(rl_article)
        bottomViews.add(rl_category)
        bottomViews.add(rl_my)

        for (view in bottomViews) {
            view.setOnClickListener(this)
        }
        setBottomBarSelect(0)
    }

    private fun setBottomBarSelect(i: Int) {
        for (view in bottomViews) {
            view.isSelected = false
        }
        bottomViews[i].isSelected = true
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector

    override fun onClick(v: View?) {
        when (v) {
            rl_home -> setBottomBarSelect(0)
            rl_article -> setBottomBarSelect(1)
            rl_category -> setBottomBarSelect(2)
            rl_my -> setBottomBarSelect(3)
        }
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        setBottomBarSelect(position)
    }

    private var lastClickTime = 0L

    override fun onBackPressed() {
        val currentTimeMillis = System.currentTimeMillis()
        if (currentTimeMillis - lastClickTime > 3000) {
            showMessage("再点就退出了...")
            lastClickTime = currentTimeMillis
        } else {
            super.onBackPressed()
        }
    }
}
