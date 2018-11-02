package com.wankotlin.mvp

import android.app.Activity
import android.app.Application
import com.androidnetworking.AndroidNetworking
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import com.wankotlin.mvp.di.component.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import okhttp3.OkHttpClient
import javax.inject.Inject


/**
 * Created by amitshekhar on 24/12/17.
 */
class MvpApp : Application(), HasActivityInjector {

    @Inject
    internal lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = activityDispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()

        initDagger()
        initNetwork()
    }

    private fun initNetwork() {
        val okHttpClient = OkHttpClient().newBuilder()
                .cookieJar(PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(this)))
                .build()
        AndroidNetworking.initialize(this, okHttpClient)
    }

    private fun initDagger() {
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }

}