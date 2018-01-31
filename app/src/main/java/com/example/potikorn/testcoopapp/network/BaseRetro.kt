package com.example.potikorn.testcoopapp.network

import com.example.potikorn.testcoopapp.InterActor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BaseRetro<T> {
    fun baseRetroCaller(callService: Call<T>?, callback: InterActor.OnFinishedListener) {
        callService?.enqueue(object : Callback<T> {
            override fun onFailure(call: Call<T>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<T>?, response: Response<T>?) {
                callback.onSuccess(response?.body())
            }
        })
    }
}