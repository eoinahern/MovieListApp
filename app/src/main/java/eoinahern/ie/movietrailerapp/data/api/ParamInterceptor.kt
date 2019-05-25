package eoinahern.ie.movietrailerapp.data.api

import eoinahern.ie.movietrailerapp.util.*
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class ParamInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val builder = originalRequest.url().newBuilder()
        val newUrl = builder.addQueryParameter(CLASSIFICATION_KEY, "6")
            .addQueryParameter(DEVICE_ID_KEY, DEVICE_TYPE)
            .addQueryParameter(LOCALE_KEY, ESP_COUNTRY_CODE)
            .addQueryParameter(MARKET_CODE_KEY, ESP_COUNTRY_CODE)
            .build()

        return chain.proceed(originalRequest.newBuilder().url(newUrl).build())
    }
}