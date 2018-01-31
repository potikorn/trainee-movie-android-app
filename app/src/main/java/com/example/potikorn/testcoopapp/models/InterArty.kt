package com.example.potikorn.testcoopapp.models

import com.example.potikorn.testcoopapp.InterActor
import com.example.potikorn.testcoopapp.models.movie.MovieList
import com.example.potikorn.testcoopapp.models.television.TelevisionList
import com.example.potikorn.testcoopapp.network.ApiManager
import com.example.potikorn.testcoopapp.network.BaseRetro
import com.example.potikorn.testcoopapp.network.BaseUrl

class InterArty : InterActor.ActData {
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