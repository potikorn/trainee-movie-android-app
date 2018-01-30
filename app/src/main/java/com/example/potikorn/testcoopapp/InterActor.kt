package com.example.potikorn.testcoopapp

import com.example.potikorn.testcoopapp.models.movie.Movie
import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.models.YouVidData

interface InterActor {
    interface OnFinishedListener {
        fun onSuccess(results: List<Movie>? = null, resultTv: List<Television>? = null, resultsYoutube: List<YouVidData>? = null)
    }

    interface ActData {
        fun callDataFromSearch(key: String, callback: OnFinishedListener)
        fun callNowPlayData(callback: OnFinishedListener)
        fun callTVDataFromSearch(key: String, callback: OnFinishedListener)
        fun callNowPlayTVData(callback: OnFinishedListener)
        fun callYoutubeData(key: String, callback: OnFinishedListener)
    }
}
