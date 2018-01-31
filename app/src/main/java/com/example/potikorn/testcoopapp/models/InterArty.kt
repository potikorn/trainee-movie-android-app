package com.example.potikorn.testcoopapp.models

import com.example.potikorn.testcoopapp.InterActor
import com.example.potikorn.testcoopapp.models.movie.MovieList
import com.example.potikorn.testcoopapp.models.movie.MovieTypeList
import com.example.potikorn.testcoopapp.models.movie.MovieVideoPathList
import com.example.potikorn.testcoopapp.models.television.TelevisionList
import com.example.potikorn.testcoopapp.models.television.TelevisionTypeList
import com.example.potikorn.testcoopapp.network.ApiManager
import com.example.potikorn.testcoopapp.network.BaseRetro
import com.example.potikorn.testcoopapp.network.BaseUrl

class InterArty : InterActor.ActData {
    override fun callMovieFilterByGenres(genres_id: String, callback: InterActor.OnFinishedListener) {
        BaseRetro<MovieList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.selectMovieByGenres(genres_id), callback)
    }

    override fun callTelevisionFilterByGenres(genres_id: String, callback: InterActor.OnFinishedListener) {
        BaseRetro<TelevisionList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.selectTelevisionByGenres(genres_id), callback)
    }

    override fun callMovieCredit(id: String, callback: InterActor.OnFinishedListener) {
        BaseRetro<CreditList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.selectMovieCredit(id), callback)
    }

    override fun callTelevisionCredit(id: String, callback: InterActor.OnFinishedListener) {
        BaseRetro<CreditList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.selectMovieCredit(id), callback)
    }

    override fun callTvImage(tvId: String, callback: InterActor.OnFinishedListener) {

        BaseRetro<ImageList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.selectTelevisionImage(tvId), callback)

    }

    override fun callMovieGenres(callback: InterActor.OnFinishedListener) {
        BaseRetro<MovieTypeList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.selectMovieGenres(), callback)

    }

    override fun callTvGenres(callback: InterActor.OnFinishedListener) {

        BaseRetro<TelevisionTypeList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.selectTelevisionGenres(), callback)

    }

    override fun callMovieVideoPath(movieId: String, callback: InterActor.OnFinishedListener) {

        BaseRetro<MovieVideoPathList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.selectMovieVideoPath(movieId), callback)

    }

    override fun callTvOnTheAir(callback: InterActor.OnFinishedListener) {

        BaseRetro<TelevisionList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.televisionOnTheAir(), callback)

    }

    override fun callTvPopular(callback: InterActor.OnFinishedListener) {

        BaseRetro<TelevisionList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.televisionPopular(), callback)

    }

    override fun callTvTopRate(callback: InterActor.OnFinishedListener) {

        BaseRetro<TelevisionList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.televisionTopRate(), callback)

    }

    override fun callTvByGenres(genres: String, callback: InterActor.OnFinishedListener) {

        BaseRetro<TelevisionTypeList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.selectTelevisionGenres(), callback)

    }

    override fun callMoviePopular(callback: InterActor.OnFinishedListener) {

        BaseRetro<MovieList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.selectMoviePopular(), callback)

    }

    override fun callMovieTopRate(callback: InterActor.OnFinishedListener) {

        BaseRetro<MovieList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.selectMovieTopRate(), callback)

    }

    override fun callMovieUpcoming(callback: InterActor.OnFinishedListener) {

        BaseRetro<MovieList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.selectMovieUpcoming(), callback)

    }

    override fun callMovieByGenres(genres: String, callback: InterActor.OnFinishedListener) {

        BaseRetro<MovieTypeList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.selectMovieGenres(), callback)

    }

    override fun callMovieImage(movieId: String, callback: InterActor.OnFinishedListener) {

        BaseRetro<ImageList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.selectMovieImage(movieId), callback)

    }

    override fun callNowPlayData(callback: InterActor.OnFinishedListener) {
        val callService = ApiManager.Factory.create(BaseUrl.baseUrl)?.nowPlaying()
        BaseRetro<MovieList>().baseRetroCaller(callService, callback)
    }

    override fun callNowPlayTVData(callback: InterActor.OnFinishedListener) {
        val callService = ApiManager.Factory.create(BaseUrl.baseUrl)?.nowTelevisionPlaying()
        BaseRetro<TelevisionList>().baseRetroCaller(callService, callback)
    }

    override fun callYoutubeData(key: String, callback: InterActor.OnFinishedListener) {
        BaseRetro<VidListFOF>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.searchYoutube(key), callback)
    }

    override fun callDataFromSearch(key: String, callback: InterActor.OnFinishedListener) {
        val callService = ApiManager.Factory.create(BaseUrl.baseUrl)?.search(key)
        BaseRetro<MovieList>().baseRetroCaller(callService, callback)
    }

    override fun callTVDataFromSearch(key: String, callback: InterActor.OnFinishedListener) {
        BaseRetro<TelevisionList>().baseRetroCaller(ApiManager.create(BaseUrl.baseUrl)?.searchTelevision(key), callback)
    }
}