package com.example.potikorn.testcoopapp.contactor

import com.example.potikorn.testcoopapp.models.YouVidData
import com.example.potikorn.testcoopapp.models.movie.Movie
import com.example.potikorn.testcoopapp.models.television.Television

interface MainContractor {
    interface Presenter {
        fun callBackData(string: String?=null)
        fun callBackTvActorData()
        fun callBackMovieActorData()
    }

    interface View {
        fun callBackData(arr: List<Movie>? = null, arrTv: List<Television>? = null, resultsYoutube: List<YouVidData>? = null)
    }
}