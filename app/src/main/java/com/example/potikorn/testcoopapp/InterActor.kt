package com.example.potikorn.testcoopapp

import com.example.potikorn.testcoopapp.models.Movie
import com.example.potikorn.testcoopapp.models.Television

interface InterActor{
    interface OnFinishedListener{
        fun onSuccess(results:List<Movie>?=null,resultTv:List<Television>?=null)
    }
    interface ActData{
        fun callDataFromSearch(key:String , callback: OnFinishedListener)
        fun callNowPlayData(callback: OnFinishedListener)
        fun callTVDataFromSearch(key:String , callback: OnFinishedListener)
        fun callNowPlayTVData(callback: OnFinishedListener)
    }
}
