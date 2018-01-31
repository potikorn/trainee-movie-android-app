package com.example.potikorn.testcoopapp

interface InterActor {
    interface OnFinishedListener {
        fun <T> onSuccess(t: T)
    }

    interface ActData {
        fun callYoutubeData(key: String, callback: OnFinishedListener)
        fun callTVDataFromSearch(key: String, callback: OnFinishedListener)
        fun callNowPlayTVData(callback: OnFinishedListener)
        fun callTvOnTheAir(callback: OnFinishedListener)
        fun callTvPopular(callback: OnFinishedListener)
        fun callTvTopRate(callback: OnFinishedListener)
        fun callTvByGenres(genres : String , callback: OnFinishedListener)
        fun callMoviePopular(callback: OnFinishedListener)
        fun callMovieTopRate(callback: OnFinishedListener)
        fun callMovieUpcoming(callback: OnFinishedListener)
        fun callMovieNTelevisionCredit(id: String, callback: OnFinishedListener)
        fun callMovieByGenres(genres : String , callback: OnFinishedListener)
        fun callMovieImage(movieId: String, callback: OnFinishedListener)
        fun callGenres(callback: OnFinishedListener)
        fun callVideoPath(movieId: String, callback: OnFinishedListener)
        fun callDataFromSearch(key: String, callback: OnFinishedListener)
        fun callNowPlayData(callback: OnFinishedListener)
    }
}
