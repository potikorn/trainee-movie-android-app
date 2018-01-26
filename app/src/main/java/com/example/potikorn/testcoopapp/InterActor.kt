package com.example.potikorn.testcoopapp

import com.example.potikorn.testcoopapp.models.MovieList

class InterActor {
    interface OnFinishedListener {
        fun onSuccess(results: MovieList)
    }

    interface ActData {
        fun callDataFromSearch(key: String, callback: OnFinishedListener)
        fun callNowPlayData(callback: OnFinishedListener)
    }
}
