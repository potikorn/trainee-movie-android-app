package com.example.potikorn.testcoopapp.presenter
import com.example.potikorn.testcoopapp.InterActor
import com.example.potikorn.testcoopapp.contracter.MainContractor
import com.example.potikorn.testcoopapp.models.InterArty
import com.example.potikorn.testcoopapp.models.movie.Movie
import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.models.YouVidData

class TelevisionPresenter(val view: MainContractor.View? = null) : MainContractor.Presenter, InterActor.OnFinishedListener {
    override fun onSuccess(results: List<Movie>?, resultTv: List<Television>?, resultsYoutube: List<YouVidData>?) {
        view?.callBackData(results, resultTv)
    }

    private val act: InterActor.ActData by lazy { InterArty() }

    override fun callBackData(key: String?) = act.callNowPlayTVData(this)
}