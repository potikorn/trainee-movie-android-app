package com.example.potikorn.testcoopapp.contactor
import com.example.potikorn.testcoopapp.models.CreditActor
import com.example.potikorn.testcoopapp.models.Crew
import com.example.potikorn.testcoopapp.models.movie.Movie
import com.example.potikorn.testcoopapp.models.movie.MovieType

interface MovieFragmentContractor {

    interface Presenter {
        fun callPopularData(key: String? = null)
        fun topRateData(key: String? = null)
        fun callGenres()
        fun callActor(key:String?)
        fun callCrew(key:String?)
    }

    interface View {
        fun callbackGenres(arrMovie: List<MovieType>?)
        fun callBackPopularData(arrMovie: List<Movie>?)
        fun callTopRateData(arrMovie: List<Movie>?)
        fun callCredit(arrActor: List<CreditActor>?)
        fun callCrew(arrActor: List<Crew>?)
    }
}