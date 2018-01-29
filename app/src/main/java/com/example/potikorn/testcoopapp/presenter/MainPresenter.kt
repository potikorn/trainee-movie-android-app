package com.example.potikorn.testcoopapp.presenter

import com.example.potikorn.testcoopapp.InterActor
import com.example.potikorn.testcoopapp.contracter.MainContractor
import com.example.potikorn.testcoopapp.models.InterArty
import com.example.potikorn.testcoopapp.models.Movie
import com.example.potikorn.testcoopapp.models.Television

class MainPresenter(val view: MainContractor.View? = null) : MainContractor.Presenter, InterActor.OnFinishedListener {

    override fun onSuccess(results: List<Movie>?, resultTv: List<Television>?) {
        view?.callBackData(results)
    }

    private val act: InterActor.ActData by lazy { InterArty() }

    override fun callBackData(key: String?) = act.callNowPlayData(this)
}