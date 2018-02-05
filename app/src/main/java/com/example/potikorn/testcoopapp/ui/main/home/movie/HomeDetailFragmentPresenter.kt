package com.example.potikorn.testcoopapp.ui.main.home.movie

import com.example.potikorn.testcoopapp.models.movie.MovieList
import com.example.potikorn.testcoopapp.network.ApiManager
import com.example.potikorn.testcoopapp.network.BaseUrl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeDetailFragmentPresenter(private val view: HomeDetailFragmentContract.View) :
        HomeDetailFragmentContract.Presenter {

    override fun requestInTheater() {
        ApiManager.create(BaseUrl.baseUrl)?.nowPlaying()?.enqueue(object : Callback<MovieList> {
            override fun onFailure(call: Call<MovieList>?, t: Throwable?) {
                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<MovieList>?, response: Response<MovieList>?) {
                view.getInTheaterData(response?.body() ?: MovieList())
            }
        })
    }
}