package com.example.potikorn.testcoopapp.models

import android.util.Log
import com.example.potikorn.testcoopapp.InterActor
import com.example.potikorn.testcoopapp.network.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InterActy : InterActor.ActData {

    private val api = BaseRetrofit()

    override fun callNowPlayData(callback: InterActor.OnFinishedListener) {
        val observableNowPlaying = api.createService(BaseService::class.java).newNowPlaying()
        observableNowPlaying.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : DisposableObserver<Response<MovieList>>() {
                    override fun onComplete() {

                    }

                    override fun onNext(t: Response<MovieList>) {
                        callback.onSuccess(t.body() as MovieList)
                    }

                    override fun onError(e: Throwable) {
                        Log.e("ERROR", e.message)
                    }
                })
    }

    override fun callDataFromSearch(key: String, callback: InterActor.OnFinishedListener) {
        ApiManager.Factory.create(BaseUrl.baseUrl)?.search(key)?.enqueue(object : Callback<MovieList> {
            override fun onFailure(call: Call<MovieList>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<MovieList>?, response: Response<MovieList>?) {
                //TODO : Some thing with this data response.body...
            }
        })
    }
}