package com.example.potikorn.testcoopapp.contracter

import com.example.potikorn.testcoopapp.models.Movie

interface MainContractor {
    interface Presenter{
        fun callBackData(key : String?=null)
    }
    interface View{
        fun callBackData(arr : List<Movie>?)
    }
}