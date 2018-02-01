package com.example.potikorn.testcoopapp

import com.example.potikorn.testcoopapp.models.television.TelevisionList
import com.example.potikorn.testcoopapp.models.television.TelevisionTypeList

interface InterActor {
    interface OnFinishedListener {
        fun <T> onSuccess(t: T)
    }

    interface OnFinishedListenerTv {
        fun onSuccessTop(t: TelevisionList)
        fun onSuccessPop(t: TelevisionList)
        fun onSuccessGenres(t : TelevisionTypeList)
    }

    interface ActData {
        fun callYoutubeData(key: String, callback: OnFinishedListener)
        fun callTVDataFromSearch(key: String, callback: OnFinishedListener)
        fun callNowPlayTVData(callback: OnFinishedListener)
        fun callTvOnTheAir(callback: OnFinishedListener)
        //TODO change this
        fun callTvPopular(callback: OnFinishedListenerTv)
        //TODO chenge this
        fun callTvTopRate(callback: OnFinishedListenerTv)

        fun callTvByGenres(genres: String, callback: OnFinishedListener)
        fun callTvImage(tvId: String, callback: OnFinishedListener)
        fun callMoviePopular(callback: OnFinishedListener)
        fun callMovieTopRate(callback: OnFinishedListener)
        fun callMovieUpcoming(callback: OnFinishedListener)
        fun callMovieCredit(id: String, callback: OnFinishedListener)
        fun callTelevisionCredit(id: String, callback: OnFinishedListener)
        fun callMovieByGenres(genres: String, callback: OnFinishedListener)
        fun callMovieImage(movieId: String, callback: OnFinishedListener)
        fun callMovieGenres(callback: OnFinishedListener)
        fun callMovieFilterByGenres(genres_id: String, callback: OnFinishedListener)
        fun callTvGenres(callback: OnFinishedListenerTv)
        fun callMovieVideoPath(movieId: String, callback: OnFinishedListener)
        fun callDataFromSearch(key: String, callback: OnFinishedListener)
        fun callNowPlayData(callback: OnFinishedListener)
    }
}
