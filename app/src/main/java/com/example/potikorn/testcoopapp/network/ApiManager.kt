package com.example.potikorn.testcoopapp.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Suppress("UNREACHABLE_CODE")
class ApiManager {

    companion object Factory {
        private var serviceFactory: BaseService? = null
        fun create(baseUrl: String): BaseService? {
            serviceFactory = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(baseUrl)
                    .client(setOkHttpClient())
                    .build().create(BaseService::class.java)
            return serviceFactory
        }

        fun createRx() : BaseService?{
            val retrofit = Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BaseUrl.baseUrl).client(setOkHttpClient()).build()
            return retrofit.create(BaseService::class.java)
        }


        private fun setOkHttpClient(): OkHttpClient {
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
}