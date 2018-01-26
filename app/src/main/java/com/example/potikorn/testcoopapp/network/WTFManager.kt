package com.example.fluke.fuckermovie2.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor


class WTFManager {

    companion object Factory {
        var serviceWTF: BaseService? = null
        fun create(baseUrl: String): BaseService? {
            serviceWTF = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(baseUrl)
                    .client(setOkHttpClient())
                    .build().create(BaseService::class.java)
            return serviceWTF
        }

        private fun setOkHttpClient(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val okHttpBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
                    .addInterceptor (interceptor)
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