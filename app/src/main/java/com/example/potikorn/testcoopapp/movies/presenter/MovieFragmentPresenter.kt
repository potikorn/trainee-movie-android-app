package com.example.potikorn.testcoopapp.movies.presenter
import com.example.potikorn.testcoopapp.InterActor
import com.example.potikorn.testcoopapp.contracter.MovieFragmentContractor
import com.example.potikorn.testcoopapp.models.InterArty
import com.example.potikorn.testcoopapp.models.movie.MovieList
import com.example.potikorn.testcoopapp.models.movie.MovieTypeList


class MovieFragmentPresenter (val view: MovieFragmentContractor.View? = null) : MovieFragmentContractor.Presenter, InterActor.OnFinishedListenerMovie {

    private val act: InterActor.ActData by lazy { InterArty() }
    override fun <T> onSuccessTop(t: T) {
        view?.callTopRateData(arrMovie = (t as MovieList).results)
    }

    override fun <T> onSuccessPop(t: T) {
        view?.callBackPopularData(arrMovie = (t as MovieList).results)
    }

    override fun <T> onSuccessGenres(t: T) {
        view?.callbackGenres(arrMovie = (t as MovieTypeList).type)
    }



    override fun callPopularData(key: String?) {
        act.callMoviePopular(this)
    }

    override fun topRateData(key: String?) {
       act.callMovieTopRate(this)
    }

    override fun callGenres() {
        act.callMovieGenres(this)
    }




}