package com.example.login_poc.util

import com.example.login_poc.util.Constants.Companion.API_KEY
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var original = chain.request()

        val url = original.url.newBuilder().addQueryParameter("apiKey", API_KEY).build()
        original = original.newBuilder().url(url).build()
        return chain.proceed(original)
    }
}
