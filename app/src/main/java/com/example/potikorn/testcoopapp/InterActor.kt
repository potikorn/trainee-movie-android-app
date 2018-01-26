package com.example.potikorn.testcoopapp

import com.example.potikorn.testcoopapp.models.MovieList

interface InterActor{
    interface OnFinishedListener{
        fun onSuccess(results:List<MovieList>) //TODO : onSuccess call back data list of movie
    }

    interface ActData{
        fun callDataFromSearch(key:String , callback: OnFinishedListener)
        fun callNowPlayData(callback: OnFinishedListener)
    }
}
