package com.example.potikorn.testcoopapp.contracter

import com.example.potikorn.testcoopapp.models.Movie

interface MainContractor {
    interface Presenter{
        fun callBackData()
    }
    interface View{
        fun callBackData(arr : List<Movie>?)
    }
}