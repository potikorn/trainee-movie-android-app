package com.example.potikorn.testcoopapp.television.presenter

import com.example.potikorn.testcoopapp.InterActor
import com.example.potikorn.testcoopapp.contactor.TelevisionFragmentContractor
import com.example.potikorn.testcoopapp.models.CreditList
import com.example.potikorn.testcoopapp.models.InterArty
import com.example.potikorn.testcoopapp.models.television.TelevisionList
import com.example.potikorn.testcoopapp.models.television.TelevisionTypeList

class TvGenresShowDetailPresenter(val view: TelevisionFragmentContractor.View? = null) : TelevisionFragmentContractor.Presenter, InterActor.OnFinishedListenerTv {
    override fun callActor(key: String?) {

    }

    override fun callCrew(key: String?) {
    }

    override fun onSuccessActor(t: CreditList) {
    }

    override fun onSuccessCrew(t: CreditList) {
    }


    private val act: InterActor.ActData by lazy { InterArty() }

    override fun callPopularData(key: String?) {
    }

    override fun topRateData(key: String?) {
        act.callTvByGenres(key.toString(), this)
    }

    override fun callGenres() {
    }

    override fun onSuccessTop(t: TelevisionList) {
        view?.callTopRateData(arrTv = t.results)
    }

    override fun onSuccessPop(t: TelevisionList) {
    }

    override fun onSuccessGenres(t: TelevisionTypeList) {
    }

}