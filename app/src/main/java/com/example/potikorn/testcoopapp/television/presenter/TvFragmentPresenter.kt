package com.example.potikorn.testcoopapp.television.presenter

import android.util.Log
import com.example.potikorn.testcoopapp.InterActor
import com.example.potikorn.testcoopapp.contactor.TelevisionFragmentContractor
import com.example.potikorn.testcoopapp.models.CreditList
import com.example.potikorn.testcoopapp.models.InterArty
import com.example.potikorn.testcoopapp.models.television.TelevisionList
import com.example.potikorn.testcoopapp.models.television.TelevisionTypeList

class TvFragmentPresenter(val view: TelevisionFragmentContractor.View? = null) : TelevisionFragmentContractor.Presenter, InterActor.OnFinishedListenerTv {
    private val act: InterActor.ActData by lazy { InterArty() }

    override fun callActor(key: String?) = act.callTelevisionActor(key.toString(), this)

    override fun callCrew(key: String?) = act.callTelevisionCrew(key.toString(), this)

    override fun onSuccessActor(t: CreditList) {
        view?.callCredit(arrActor = t.cast_data)
    }

    override fun onSuccessCrew(t: CreditList) {
         view?.callCrew(arrActor = t.crew_data)
    }

    override fun callPopularData(key: String?) = act.callTvPopular(this)
    override fun topRateData(key: String?) = act.callTvTopRate(this)
    override fun callGenres() = act.callTvGenres(this)

    override fun onSuccessGenres(t: TelevisionTypeList) {
        view?.callbackGenres(t.type)
    }

    override fun onSuccessPop(t: TelevisionList) {
        view?.callBackPopularData(arrTv = t.results)
    }

    override fun onSuccessTop(t: TelevisionList) {
        Log.e("this will be show", t.results.toString())
        view?.callTopRateData(arrTv = t.results)
    }
}