package com.example.potikorn.testcoopapp.ui.main.home.movie

import com.example.potikorn.testcoopapp.models.movie.MovieList

interface HomeDetailFragmentContract {

    interface View {
        fun getInTheaterData(dataList: MovieList)
    }

    interface Presenter {
        fun requestInTheater()
    }

}