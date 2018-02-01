package com.example.potikorn.testcoopapp.contracter

import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.models.television.TelevisionType

interface TelevisionFragmentContractor {
    interface Presenter {
        fun callPopularData(key: String? = null)
        fun topRateData(key: String? = null)
        fun callGenres()
    }

    interface View {
        fun callbackGenres(arrTv: List<TelevisionType>?)
        fun callBackPopularData(arrTv: List<Television>?)
        fun callTopRateData(arrTv: List<Television>?)
    }
}