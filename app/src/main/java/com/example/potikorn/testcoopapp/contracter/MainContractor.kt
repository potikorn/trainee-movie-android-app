package com.example.potikorn.testcoopapp.contracter

import com.example.potikorn.testcoopapp.models.MovieList

interface MainContractor {
    interface Presenter{
        fun callBackData()
    }

    interface View{
        fun callBackData(arr : List<MovieList>?)
    }
}