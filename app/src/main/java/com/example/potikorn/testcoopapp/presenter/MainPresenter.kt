package com.example.potikorn.testcoopapp.presenter

import com.example.potikorn.testcoopapp.InterActor
import com.example.potikorn.testcoopapp.contracter.MainContractor
import com.example.potikorn.testcoopapp.models.InterActy
import com.example.potikorn.testcoopapp.models.Movie
import com.example.potikorn.testcoopapp.models.MovieList

class MainPresenter(val view: MainContractor.View? = null) : MainContractor.Presenter, InterActor.OnFinishedListener {
    private val act: InterActor.ActData by lazy { InterActy() }
    override fun onSuccess(results: List<Movie>?) {
        view?.callBackData(results)
    }

    override fun callBackData() = act.callNowPlayData(this)
}