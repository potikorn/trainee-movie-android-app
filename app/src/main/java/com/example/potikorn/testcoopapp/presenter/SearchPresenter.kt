package com.example.potikorn.testcoopapp.presenter
import com.example.potikorn.testcoopapp.InterActor
import com.example.potikorn.testcoopapp.contracter.MainContractor
import com.example.potikorn.testcoopapp.models.InterArty
import com.example.potikorn.testcoopapp.models.movie.MovieList

class SearchPresenter(val view: MainContractor.View? = null) : MainContractor.Presenter, InterActor.OnFinishedListener {
    override fun <T> onSuccess(t: T) {
        view?.callBackData(arr = (t as MovieList).results)
    }

    private val act: InterActor.ActData by lazy { InterArty() }

    override fun callBackData(key: String?) {act.callDataFromSearch(key.toString(), this)}

}
