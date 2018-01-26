package com.example.potikorn.testcoopapp.models

import com.example.potikorn.testcoopapp.network.ApiManager
import com.example.potikorn.testcoopapp.network.BaseUrl
import com.example.potikorn.testcoopapp.InterActor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InterActy : InterActor.ActData {
    override fun callNowPlayData(callback: InterActor.OnFinishedListener) {
        ApiManager.Factory.create(BaseUrl.baseUrl)?.nowPlaying()?.enqueue(object : Callback<MovieList> {
            override fun onFailure(call: Call<MovieList>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<MovieList>?, response: Response<MovieList>?) {
                callback.onSuccess(response?.body()?.results)
            }

        })
    }

    override fun callDataFromSearch(key: String, callback: InterActor.OnFinishedListener) {
        ApiManager.Factory.create(BaseUrl.baseUrl)?.search(key)?.enqueue(object : Callback<MovieList> {
            override fun onFailure(call: Call<MovieList>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<MovieList>?, response: Response<MovieList>?) {

            }
        })
    }

}