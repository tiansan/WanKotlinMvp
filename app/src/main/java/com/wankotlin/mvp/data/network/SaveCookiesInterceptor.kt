package com.githubly.wanandroid.net

import com.wankotlin.mvp.data.preferences.PreferenceHelper
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.util.*
import javax.inject.Inject

/**
 * 保存Cookie
 */
class SaveCookiesInterceptor : Interceptor {

    @Inject
    internal lateinit var preferenceHelper: PreferenceHelper

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalResponse = chain.proceed(chain.request())
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            val cookies = HashSet<String>()
            for (header in originalResponse.headers("Set-Cookie")) {
                cookies.add(header)
            }
            preferenceHelper?.saveCookie(cookies)
        }
        return originalResponse
    }
}
