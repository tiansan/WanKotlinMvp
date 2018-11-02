package com.githubly.wanandroid.net

import com.wankotlin.mvp.data.preferences.PreferenceHelper
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

/**
 * 读取cookie并设置
 */
class ReadCookiesInterceptor : Interceptor {

    @Inject
    internal lateinit var preferenceHelper: PreferenceHelper

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        val preferences = preferenceHelper.getCookie()
        preferences?.let {
            for (cookie in preferences) {
                builder.addHeader("Cookie", cookie)
            }
        }
        return chain.proceed(builder.build())
    }
}
