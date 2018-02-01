package com.example.potikorn.testcoopapp.contracter
import com.example.potikorn.testcoopapp.models.movie.Movie
import com.example.potikorn.testcoopapp.models.movie.MovieType

interface MovieFragmentContractor {

    interface Presenter {
        fun callPopularData(key: String? = null)
        fun topRateData(key: String? = null)
        fun callGenres()
    }

    interface View {
        fun callbackGenres(arrMovie: List<MovieType>?)
        fun callBackPopularData(arrMovie: List<Movie>?)
        fun callTopRateData(arrMovie: List<Movie>?)
    }
}