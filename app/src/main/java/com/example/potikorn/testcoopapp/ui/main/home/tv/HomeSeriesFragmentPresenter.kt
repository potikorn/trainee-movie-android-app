package com.example.potikorn.testcoopapp.ui.main.home.tv

import com.example.potikorn.testcoopapp.models.television.TelevisionList
import com.example.potikorn.testcoopapp.network.ApiManager
import com.example.potikorn.testcoopapp.network.BaseUrl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeSeriesFragmentPresenter(private val view: HomeSeriesFragmentContract.View) :
        HomeSeriesFragmentContract.Presenter {

    override fun requestNowOnAir() {
        ApiManager.create(BaseUrl.baseUrl)?.nowTelevisionPlaying()?.enqueue(object: Callback<TelevisionList>{
            override fun onFailure(call: Call<TelevisionList>?, t: Throwable?) {
                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<TelevisionList>?, response: Response<TelevisionList>?) {
                view.getOnAirSeriesData(response?.body() ?: TelevisionList())
            }
        })
    }
}