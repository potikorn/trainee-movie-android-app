package com.example.potikorn.testcoopapp.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class BaseRetrofit {

    inline fun <reified T> createService(anyService: Class<T>): T {
        return Retrofit.Builder()
                .baseUrl(BaseUrl.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(setOkHttpClient())
                .build()
                .create(anyService)
    }

    fun setOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor { chain ->
                    val original = chain.request()
                    val originalHttpUrl = original.url()
                    val url = originalHttpUrl.newBuilder()
                            .addQueryParameter("api_key", "c1618550083ac39008a92222d9c8a6a9")
                            .build()
                    val requestBuilder = original.newBuilder()
                            .url(url)
                    val request = requestBuilder.build()
                    return@addInterceptor chain.proceed(request)
                }
        return okHttpBuilder.build()
    }
}