package com.example.potikorn.testcoopapp.contactor

import com.example.potikorn.testcoopapp.models.CreditActor
import com.example.potikorn.testcoopapp.models.Crew
import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.models.television.TelevisionType

interface TelevisionFragmentContractor {
    interface Presenter {
        fun callPopularData(key: String? = null)
        fun topRateData(key: String? = null)
        fun callGenres()
        fun callActor(key:String?)
        fun callCrew(key:String?)
    }

    interface View {
        fun callbackGenres(arrTv: List<TelevisionType>?)
        fun callBackPopularData(arrTv: List<Television>?)
        fun callTopRateData(arrTv: List<Television>?)
        fun callCredit(arrActor: List<CreditActor>?=null)
        fun callCrew(arrActor: List<Crew>?)
    }
}