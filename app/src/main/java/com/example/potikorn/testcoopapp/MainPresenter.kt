package com.example.potikorn.testcoopapp

import com.example.potikorn.testcoopapp.models.InterActy
import com.example.potikorn.testcoopapp.models.MovieList

class MainPresenter(private val view: MainContract.View):
        MainContract.Presenter,
        InterActor.OnFinishedListener{

    val interActor = InterActy()

    override fun requestNowPlaying() {
        interActor.callNowPlayData(this)
    }

    override fun onSuccess(results: MovieList) {
        view.onNowMovieDataSuccess(results)
    }
}