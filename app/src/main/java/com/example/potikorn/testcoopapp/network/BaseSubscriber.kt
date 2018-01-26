package com.example.potikorn.testcoopapp.network

import com.example.potikorn.testcoopapp.models.MovieList

class BaseSubscriber {

    interface OnFinishedListener {
        fun <T> onSuccess(t: T?)
    }

}