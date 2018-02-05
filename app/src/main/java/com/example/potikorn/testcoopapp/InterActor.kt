package com.example.potikorn.testcoopapp

import com.example.potikorn.testcoopapp.models.CreditActor
import com.example.potikorn.testcoopapp.models.CreditList
import com.example.potikorn.testcoopapp.models.television.TelevisionList
import com.example.potikorn.testcoopapp.models.television.TelevisionTypeList

interface InterActor {
    interface OnFinishedListenerMovie {
        fun <T> onSuccessTop(t: T)
        fun <T> onSuccessPop(t: T)
        fun <T> onSuccessGenres(t: T)
        fun onSuccessActor(t : CreditList)
        fun onSuccessCrew(t : CreditList)
    }

    interface OnFinishedListenerTv {
        fun onSuccessTop(t: TelevisionList)
        fun onSuccessPop(t: TelevisionList)
        fun onSuccessGenres(t : TelevisionTypeList)
        fun onSuccessActor(t : CreditList)
        fun onSuccessCrew(t : CreditList)
    }

    interface ActData {
        fun callYoutubeData(key: String, callback: OnFinishedListenerMovie)
        fun callTVDataFromSearch(key: String, callback: OnFinishedListenerMovie)
        fun callNowPlayTVData(callback: OnFinishedListenerMovie)
        fun callTvOnTheAir(callback: OnFinishedListenerMovie)
        //TODO change this
        fun callTvPopular(callback: OnFinishedListenerTv)
        //TODO chenge this
        fun callTvTopRate(callback: OnFinishedListenerTv)
        //Todo change this
        fun callTvByGenres(genres: String, callback: OnFinishedListenerTv)
        fun callTvImage(tvId: String, callback: OnFinishedListenerMovie)
        fun callMoviePopular(callback: OnFinishedListenerMovie)
        fun callMovieTopRate(callback: OnFinishedListenerMovie)
        fun callMovieUpcoming(callback: OnFinishedListenerMovie)
        fun callMovieActor(id: String, callback: OnFinishedListenerMovie)
        fun callMovieCrew(id: String, callback: OnFinishedListenerMovie)
        //todo use this
        fun callTelevisionActor(id: String, callback: OnFinishedListenerTv)
        fun callTelevisionCrew(id: String, callback: OnFinishedListenerTv)
        ////todo use this
        fun callMovieByGenres(genres: String, callback: OnFinishedListenerMovie)
        fun callMovieImage(movieId: String, callback: OnFinishedListenerMovie)
        fun callMovieGenres(callback: OnFinishedListenerMovie)
        fun callTvGenres(callback: OnFinishedListenerTv)
        fun callMovieVideoPath(movieId: String, callback: OnFinishedListenerMovie)
        fun callDataFromSearch(key: String, callback: OnFinishedListenerMovie)
        fun callNowPlayData(callback: OnFinishedListenerMovie)
    }
}
