package com.example.potikorn.testcoopapp
import com.example.potikorn.testcoopapp.models.Movie
interface InterActor{
    interface OnFinishedListener{
        fun onSuccess(results:List<Movie>?)
    }
    interface ActData{
        fun callDataFromSearch(key:String , callback: OnFinishedListener)
        fun callNowPlayData(callback: OnFinishedListener)
    }
}
