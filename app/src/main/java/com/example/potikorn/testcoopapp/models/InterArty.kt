package com.example.potikorn.testcoopapp.models

import com.example.potikorn.testcoopapp.InterActor
import com.example.potikorn.testcoopapp.models.movie.MovieList
import com.example.potikorn.testcoopapp.models.television.TelevisionList
import com.example.potikorn.testcoopapp.network.ApiManager
import com.example.potikorn.testcoopapp.network.BaseUrl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InterArty : InterActor.ActData {

    override fun callYoutubeData(key: String, callback: InterActor.OnFinishedListener) {
        ApiManager.Factory.create(BaseUrl.baseYouUrl)?.searchYoutube(key)?.enqueue(object : Callback<VidListFOF> {
            override fun onFailure(call: Call<VidListFOF>?, t: Throwable?) {}
            override fun onResponse(call: Call<VidListFOF>?, response: Response<VidListFOF>?) {
                callback.onSuccess(arrayListOf(), arrayListOf(), response?.body()?.results)
            }
        })
    }

    override fun callTVDataFromSearch(key: String, callback: InterActor.OnFinishedListener) {
        ApiManager.Factory.create(BaseUrl.baseUrl)?.searchTelevision(key)?.enqueue(object : Callback<TelevisionList> {
            override fun onFailure(call: Call<TelevisionList>?, t: Throwable?) {}

            override fun onResponse(call: Call<TelevisionList>?, response: Response<TelevisionList>?) {
                callback.onSuccess(arrayListOf(), response?.body()?.results)
            }
        })
    }

    override fun callNowPlayTVData(callback: InterActor.OnFinishedListener) {
        ApiManager.Factory.create(BaseUrl.baseUrl)?.nowTelevisionPlaying()?.enqueue(object : Callback<TelevisionList> {
            override fun onFailure(call: Call<TelevisionList>?, t: Throwable?) {}
            override fun onResponse(call: Call<TelevisionList>?, response: Response<TelevisionList>?) {
                callback.onSuccess(arrayListOf(), response?.body()?.results)
            }
        })
    }

    override fun callNowPlayData(callback: InterActor.OnFinishedListener) {
        ApiManager.Factory.create(BaseUrl.baseUrl)?.nowPlaying()?.enqueue(object : Callback<MovieList> {
            override fun onFailure(call: Call<MovieList>?, t: Throwable?) {}
            override fun onResponse(call: Call<MovieList>?, response: Response<MovieList>?) {
                callback.onSuccess(response?.body()?.results)
            }
        })
    }

    override fun callDataFromSearch(key: String, callback: InterActor.OnFinishedListener) {
        ApiManager.Factory.create(BaseUrl.baseUrl)?.search(key)?.enqueue(object : Callback<MovieList> {
            override fun onFailure(call: Call<MovieList>?, t: Throwable?) {}
            override fun onResponse(call: Call<MovieList>?, response: Response<MovieList>?) {
                callback.onSuccess(response?.body()?.results)
            }
        })
    }
}