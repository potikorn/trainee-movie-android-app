package com.example.potikorn.testcoopapp.contracter
import com.example.potikorn.testcoopapp.models.movie.Movie
import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.models.YouVidData

interface MainContractor {
    interface Presenter { fun callBackData(key: String? = null) }

    interface View {
        fun callBackData(arr: List<Movie>? = null, arrTv: List<Television>? = null, resultsYoutube: List<YouVidData>? = null)
    }
}