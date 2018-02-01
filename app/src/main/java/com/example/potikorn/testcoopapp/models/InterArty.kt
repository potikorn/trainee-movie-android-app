package com.example.potikorn.testcoopapp.models

import android.util.Log
import com.example.potikorn.testcoopapp.InterActor
import com.example.potikorn.testcoopapp.models.movie.MovieList
import com.example.potikorn.testcoopapp.models.movie.MovieTypeList
import com.example.potikorn.testcoopapp.models.movie.MovieVideoPathList
import com.example.potikorn.testcoopapp.models.television.TelevisionList
import com.example.potikorn.testcoopapp.models.television.TelevisionTypeList
import com.example.potikorn.testcoopapp.network.ApiManager
import com.example.potikorn.testcoopapp.network.BaseRetro
import com.example.potikorn.testcoopapp.network.BaseUrl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class InterArty : InterActor.ActData {

    override fun callMovieCredit(id: String, callback: InterActor.OnFinishedListenerMovie) {
        BaseRetro<CreditList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.selectMovieCredit(id), callback)
    }

    override fun callTelevisionCredit(id: String, callback: InterActor.OnFinishedListenerMovie) {
        BaseRetro<CreditList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.selectMovieCredit(id), callback)
    }

    override fun callTvImage(tvId: String, callback: InterActor.OnFinishedListenerMovie) {

        BaseRetro<ImageList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.selectTelevisionImage(tvId), callback)

    }

    //**
    override fun callMovieGenres(callback: InterActor.OnFinishedListenerMovie) {
        val baseService by lazy { ApiManager.createRx() }
        baseService?.selectMovieGenres()?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(object : DisposableObserver<Response<MovieTypeList>>() {
                    override fun onComplete() {
                    }

                    override fun onNext(t: Response<MovieTypeList>) {
                        t.body()?.let { callback.onSuccessGenres(it) }
                    }

                    override fun onError(e: Throwable) {
                    }
                })

    }

    override fun callTvGenres(callback: InterActor.OnFinishedListenerTv) {
        val baseService by lazy { ApiManager.createRx() }
        baseService?.selectTelevisionGenres()?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(object : DisposableObserver<Response<TelevisionTypeList>>() {
                    override fun onComplete() {
                    }

                    override fun onNext(t: Response<TelevisionTypeList>) {
                        t.body()?.let { callback.onSuccessGenres(it) }
                    }

                    override fun onError(e: Throwable) {
                    }
                })
    }

    override fun callMovieVideoPath(movieId: String, callback: InterActor.OnFinishedListenerMovie) {

        BaseRetro<MovieVideoPathList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.selectMovieVideoPath(movieId), callback)

    }

    override fun callTvOnTheAir(callback: InterActor.OnFinishedListenerMovie) {

        BaseRetro<TelevisionList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.televisionOnTheAir(), callback)

    }

    override fun callTvPopular(callback: InterActor.OnFinishedListenerTv) {
        val baseService by lazy { ApiManager.createRx() }
        baseService?.televisionPopular()?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(object : DisposableObserver<Response<TelevisionList>>() {
                    override fun onComplete() {
                    }

                    override fun onNext(t: Response<TelevisionList>) {
                        Log.e("success data here", t.body()?.results.toString())
                        t.body()?.let { callback.onSuccessPop(it) }
                    }

                    override fun onError(e: Throwable) {
                    }
                })
    }

    override fun callTvTopRate(callback: InterActor.OnFinishedListenerTv) {
        val baseService by lazy { ApiManager.createRx() }
        baseService?.televisionTopRate()?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(object : DisposableObserver<Response<TelevisionList>>() {
                    override fun onComplete() {
                    }

                    override fun onNext(t: Response<TelevisionList>) {
                        Log.e("success data here", t.body()?.results.toString())
                        t.body()?.let { callback.onSuccessTop(it) }
                    }

                    override fun onError(e: Throwable) {
                    }
                })
    }

    override fun callTvByGenres(genres: String, callback: InterActor.OnFinishedListenerMovie) {

        BaseRetro<TelevisionTypeList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.selectTelevisionByGenres(genres), callback)

    }

    override fun callMoviePopular(callback: InterActor.OnFinishedListenerMovie) {

        val baseService by lazy { ApiManager.createRx() }
        baseService?.selectMoviePopular()?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(object : DisposableObserver<Response<MovieList>>() {
                    override fun onComplete() {
                    }

                    override fun onNext(t: Response<MovieList>) {
                        t.body()?.let { callback.onSuccessPop(it) }
                    }

                    override fun onError(e: Throwable) {
                    }
                })

    }

    override fun callMovieTopRate(callback: InterActor.OnFinishedListenerMovie) {

        val baseService by lazy { ApiManager.createRx() }
        baseService?.selectMovieTopRate()?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(object : DisposableObserver<Response<MovieList>>() {
                    override fun onComplete() {
                    }

                    override fun onNext(t: Response<MovieList>) {
                        t.body()?.let { callback.onSuccessTop(it) }
                    }

                    override fun onError(e: Throwable) {
                    }
                })
    }

    override fun callMovieUpcoming(callback: InterActor.OnFinishedListenerMovie) {

        BaseRetro<MovieList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.selectMovieUpcoming(), callback)

    }

    override fun callMovieByGenres(genres: String, callback: InterActor.OnFinishedListenerMovie) {}

    override fun callMovieImage(movieId: String, callback: InterActor.OnFinishedListenerMovie) {

        BaseRetro<ImageList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.selectMovieImage(movieId), callback)

    }

    override fun callNowPlayData(callback: InterActor.OnFinishedListenerMovie) {
        val callService = ApiManager.Factory.create(BaseUrl.baseUrl)?.nowPlaying()
        BaseRetro<MovieList>().baseRetroCaller(callService, callback)
    }

    override fun callNowPlayTVData(callback: InterActor.OnFinishedListenerMovie) {
        val callService = ApiManager.Factory.create(BaseUrl.baseUrl)?.nowTelevisionPlaying()
        BaseRetro<TelevisionList>().baseRetroCaller(callService, callback)
    }

    override fun callYoutubeData(key: String, callback: InterActor.OnFinishedListenerMovie) {
        BaseRetro<VidListFOF>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.searchYoutube(key), callback)
    }

    override fun callDataFromSearch(key: String, callback: InterActor.OnFinishedListenerMovie) {
        val callService = ApiManager.Factory.create(BaseUrl.baseUrl)?.search(key)
        BaseRetro<MovieList>().baseRetroCaller(callService, callback)
    }

    override fun callTVDataFromSearch(key: String, callback: InterActor.OnFinishedListenerMovie) {
        BaseRetro<TelevisionList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.searchTelevision(key), callback)
    }
}