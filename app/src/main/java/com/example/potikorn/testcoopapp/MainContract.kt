package com.example.potikorn.testcoopapp

import com.example.potikorn.testcoopapp.models.MovieList

class MainContract {

    interface View {
        fun onNowMovieDataSuccess(results: MovieList)
    }

    interface Presenter {
        fun requestNowPlaying()
    }
}