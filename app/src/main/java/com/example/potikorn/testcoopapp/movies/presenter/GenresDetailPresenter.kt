package com.example.potikorn.testcoopapp.movies.presenter

import com.example.potikorn.testcoopapp.InterActor
import com.example.potikorn.testcoopapp.contactor.MovieFragmentContractor
import com.example.potikorn.testcoopapp.models.CreditList
import com.example.potikorn.testcoopapp.models.InterArty
import com.example.potikorn.testcoopapp.models.movie.MovieList

class GenresDetailPresenter(val view: MovieFragmentContractor.View? = null) : MovieFragmentContractor.Presenter, InterActor.OnFinishedListenerMovie {
    override fun callActor(key: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccessActor(t: CreditList) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun callCrew(key: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccessCrew(t: CreditList) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val act: InterActor.ActData by lazy { InterArty() }

    override fun callPopularData(key: String?) {
    }

    override fun <T> onSuccessTop(t: T) {
        view?.callTopRateData(arrMovie = (t as MovieList).results)
    }

    override fun topRateData(key: String?) {
        act.callMovieByGenres(key.toString(), this)
    }

    override fun <T> onSuccessPop(t: T) {
    }

    override fun <T> onSuccessGenres(t: T) {
    }

    override fun callGenres() {
    }

}