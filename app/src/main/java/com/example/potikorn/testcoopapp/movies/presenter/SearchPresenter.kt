package com.example.potikorn.testcoopapp.movies.presenter
import com.example.potikorn.testcoopapp.InterActor
import com.example.potikorn.testcoopapp.contracter.MainContractor
import com.example.potikorn.testcoopapp.models.InterArty
import com.example.potikorn.testcoopapp.models.movie.MovieList

class SearchPresenter(val view: MainContractor.View? = null) : MainContractor.Presenter, InterActor.OnFinishedListenerMovie {
    override fun <T> onSuccessTop(t: T) {
        view?.callBackData((t as MovieList).results)
    }

    override fun <T> onSuccessPop(t: T) {
    }

    override fun <T> onSuccessGenres(t: T) {
    }

    private val act: InterActor.ActData by lazy { InterArty() }

    override fun callBackData(key: String?) {act.callDataFromSearch(key.toString(), this)}

}
